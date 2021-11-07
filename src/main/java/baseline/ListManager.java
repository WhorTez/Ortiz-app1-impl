/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class ListManager {
    ToDoListFunctions tdf = new ToDoListFunctions();
    String fileLocation;
    File f = new File(getFileLocation() +"/"+ getFile());

    public void writeToFile(String f, ListManager manager){
        try{
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
                bw.write(manager.tdf.title +"\n");
                bw.write(manager.tdf.itemList.size() +"\n");
                for(int i =0;i<manager.tdf.itemList.size();i++){
                    bw.write(manager.tdf.itemList.get(i).itemName +"\n");
                    bw.write(manager.tdf.itemList.get(i).description +"\n");
                    bw.write(manager.tdf.itemList.get(i).dueDate +"\n");

                    if(manager.tdf.itemList.get(i).complete.equals("true")){
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

    public ListManager loadList(String location){
        ListManager loadedList = new ListManager();
        File f = new File(location);

        try{
            try(Scanner in = new Scanner(f)){
                loadedList.tdf.title = in.nextLine();

                String listSize = in.nextLine();
                for(int i=0;i<Integer.parseInt(listSize);i++){
                    Item item = new Item();
                    item.itemName = in.nextLine();
                    item.description = in.nextLine();
                    item.dueDate = in.nextLine();

                    String completion = in.nextLine();

                    if(completion.equals("complete")){
                        item.complete = "true";
                    }else if(completion.equals("incomplete")){
                        item.complete = "false";
                    }
                    loadedList.tdf.itemList.add(item);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return loadedList;
    }

    public String createNewList(String title){
       tdf.title = title;
       System.out.println("Name for your new List: " +tdf.title);
        //gets title
        return title;
    }

    public String getFileLocation() {
        //returns file location provided by user
        return fileLocation;
    }

    public String getFile() {
        //returns file name provided by user
        return tdf.title;
    }
}
