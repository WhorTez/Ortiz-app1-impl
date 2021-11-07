/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

public class Item {
    String itemName;
    String description;
    String dueDate;
    boolean complete = false;

    public String getItemName(){
        //will get the item name
        return null;
    }

    public String getDescription() {
        //gets description of item from user
        //validates char length to be between 1 and 256
        return null;
    }

    public String getDueDate() {
        //gets dueDate for item from user
        //make sure date is on Gregorian Calendar
        //validate input to be in YYYY-MM-DD format
        return null;
    }

    public void editDescription(){
        //takes a new description to replace the old one
    }
    public void editDate(){
        //takes a new due date from the user and replaces the old one
    }

    public void changesComplete(){
        //will change completion from false to true or true to false when activated
    }

}
