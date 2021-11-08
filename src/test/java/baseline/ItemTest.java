
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void ChangeComplete() {
        Item item = new Item();
        item.name = "maintenance";
        item.complete = "yes";
        item.dueDate = "";
        item.description = "oil change";

        item.ChangeComplete();

        assertEquals("yes", item.complete);
    }

    @Test
    void getNameTest() {
        Item item = new Item();
        item.name = "maintenance";
        item.complete = "false";
        item.dueDate = "";
        item.description = "oil change";

        assertEquals("maintenance", item.getName());
    }

    @Test
    void getCompletionTest() {
        Item item = new Item();
        item.name = "maintenance";
        item.complete = "false";
        item.dueDate = "";
        item.description = "oil change";

        assertEquals("false", item.getComplete());
    }

    @Test
    void getDescriptionTest() {
        Item item = new Item();
        item.name = "maintenance";
        item.complete = "false";
        item.dueDate = "";
        item.description = "oil change";

        assertEquals("oil change", item.getDescription());
    }

    @Test
    void getDueDateTest() {
        Item item = new Item();
        item.name = "maintenance";
        item.complete = "false";
        item.dueDate = "";
        item.description = "oil change";

        assertEquals("", item.getDueDate());
    }
}