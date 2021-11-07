/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

public class Item {
    String itemName;
    String description;
    String dueDate;
    String complete;

    public Item() {
    }

    public Item(String itemName, String description, String dueDate, String complete) {
        this.itemName = itemName;
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public String getItemName() {
        //will get the item name
        return itemName;
    }

    public String getDescription() {
        //gets description of item from user
        //validates char length to be between 1 and 256
        return description;
    }

    public String getDueDate() {
        //gets dueDate for item from user
        //make sure date is on Gregorian Calendar
        //validate input to be in YYYY-MM-DD format
        return dueDate;
    }

    public String getComplete() {
        return complete;
    }

    public void editComplete(){
        if(complete.equals("false")){
            complete = "true";
        }else if(complete.equals("true")){
            complete = "false";
        }
        //will act as a checkbox in GUI
        //check = true, no check = false
    }
}
