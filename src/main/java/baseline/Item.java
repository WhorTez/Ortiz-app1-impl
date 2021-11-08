/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

public class Item {
    String name;
    String description;
    String dueDate;
    String complete;

    public Item() {
    }

    public Item(String itemName, String description, String dueDate, String completion) {
        this.name = itemName;
        this.description = description;
        this.dueDate = dueDate;
        this.complete = completion;
    }

    public String getName() {
        //will get the item name
        return name;
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

    public void ChangeComplete() {
        if (complete.equals("false")) {
            complete = "true";
        } else if(complete.equals("true")) {
        complete = "false";
    }
    }
}
