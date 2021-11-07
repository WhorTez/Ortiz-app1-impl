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
        boolean selected = false;

        public String getTitle() {
            //gets title of toDoList from user
            //validates input to make sure it is atleast 3 characters long
            return title;
        }

        public void deleteItem(Item item){
            itemList.remove(item);
        }

        public void addItem(Item newItem){
            //adds a new item to the list
            itemList.add(newItem);
        }

        public void displayAllLists(){
            //loops through all lists to show all toDoLists
        }

        public void displayCompletedTasks(List<Item> displayList){
            for(int i=0;i<itemList.size();i++){
                if(itemList.get(i).complete.equals("true")){
                    displayList.add(itemList.get(i));
                }
            }
            //loops through every lists to show the ones that have been completed
        }

        public void displayIncompleteTasks(List<Item> displayList){
            for(int i=0;i<itemList.size();i++){
                if(itemList.get(i).complete.equals("false")){
                    displayList.add(itemList.get(i));
                }
            }
            //loops through every lists to show the ones that have not been completed
        }

        public Item createItem(){
            //sets the name description and due date for a new item
            return null;
        }

        public List<Item> clearAll(){
            return new ArrayList<>();
        }
    }

