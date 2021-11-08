/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import java.util.ArrayList;
import java.util.List;

    public class ToDoListFunctions {
        String title;
        List<Item> itemList = new ArrayList<>();

        public void addItem(Item newItem){
            //adds a new item to the list
            itemList.add(newItem);
        }

        public void displayCompletedTasks(List<Item> displayList){
            for(Item item : itemList){
                if(item.complete.equals("yes")){
                    displayList.add(item);
                }
            }
            //loops through every list to show the ones that have been completed
        }

        public void displayIncompleteTasks(List<Item> displayList){
            for(Item item : itemList){
                if(item.complete.equals("no")){
                    displayList.add(item);
                }
            }
            //loops through every list to show the ones that have not been completed
        }

        public List<Item> clearAll(){
            return new ArrayList<>();
        }
    }