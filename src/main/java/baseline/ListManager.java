/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListManager {
    ToDoListFunctions tdf = new ToDoListFunctions();
    String fileLocation;
    File file = new File(getFileLocation() +"/"+ getFileName());

    public void writeToFile(String file, ListManager manager){
        try{
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                bw.write(manager.tdf.title +"\n");
                bw.write(manager.tdf.itemList.size() +"\n");
                for(int i =0;i<manager.tdf.itemList.size();i++){
                    bw.write(manager.tdf.itemList.get(i).name +"\n");
                    bw.write(manager.tdf.itemList.get(i).description +"\n");
                    bw.write(manager.tdf.itemList.get(i).dueDate +"\n");

                    if(manager.tdf.itemList.get(i).complete.equals("yes")){
                        bw.write("complete" +"\n");
                    }else{
                        bw.write("incomplete" +"\n");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //An example list with items would be as follows:
        //Back to School Shopping
        //Get Clothes       pants, shirts, socks    Due: 11/6/2021  complete
        //Get Supplies      pens, backpack, notebooks   Due: 11/15/2021 incomplete
    }

    public ListManager loadToDoList(String location){
        ListManager load = new ListManager();
        file = new File(location);

        try{
            try(Scanner in = new Scanner(file)){
                load.tdf.title = in.nextLine();

                String listSize = in.nextLine();
                for(int i=0;i<Integer.parseInt(listSize);i++){
                    Item item = new Item();
                    item.name = in.nextLine();
                    item.description = in.nextLine();
                    item.dueDate = in.nextLine();

                    String completion = in.nextLine();

                    if(completion.equals("complete")){
                        item.complete = "yes";
                    }else if(completion.equals("incomplete")){
                        item.complete = "no";
                    }
                    load.tdf.itemList.add(item);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return load;
    }

    public String getFileLocation() {
        //returns file location provided by user
        return fileLocation;
    }

    public String getFileName() {
        //returns file name provided by user
        return tdf.title;
    }
}
