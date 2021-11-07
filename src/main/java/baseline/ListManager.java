/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListManager {
    List<ToDoListFunctions> manager = new ArrayList<>();
    String fileLocation;
    String file;
    File f = new File(fileLocation +"/"+ file);

    public void deleteLists(ToDoListFunctions s){
        //gets the list selected from the GUI to make sure it exists and removes it
    }

    public ToDoListFunctions createNewList(){
        ToDoListFunctions s = new ToDoListFunctions();
        //gets title, description and date from GUI
        return s;
    }

    public void editTitle(ToDoListFunctions s){
        //changes the title of the list by asking for a new name
    }
    public String getFileLocation() {
        //returns file location provided by user
        return null;
    }

    public String getFileL() {
        //returns file name provided by user
        return null;
    }
}
