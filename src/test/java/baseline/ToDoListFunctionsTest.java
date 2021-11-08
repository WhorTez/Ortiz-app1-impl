package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListFunctionsTest {


    @Test
    void clearAll() {
        Item firstItem = new Item();
        firstItem.name = "maintenance";
        firstItem.complete = "false";
        firstItem.dueDate = "";
        firstItem.description = "oil change";

        Item secondItem = new Item();
        secondItem.name = "maintenance";
        secondItem.complete = "false";
        secondItem.dueDate = "";
        secondItem.description = "oil change";

        ToDoListFunctions test = new ToDoListFunctions();
        test.itemList.add(firstItem);
        test.itemList.add(secondItem);

        ToDoListFunctions empty = new ToDoListFunctions();

        test.itemList = test.clearAll();

        assertEquals(empty.itemList.size(), test.itemList.size());

    }

    @Test
    void addItem() {
        Item firstItem = new Item();
        firstItem.name = "maintenance";
        firstItem.complete = "false";
        firstItem.dueDate = "";
        firstItem.description = "oil change";

        ToDoListFunctions test = new ToDoListFunctions();
        test.addItem(firstItem);

        ToDoListFunctions expected = new ToDoListFunctions();
        expected.itemList.add(firstItem);

        assertEquals(expected.itemList.get(0), test.itemList.get(0));
    }

    @Test
    void displayCompletedTasks() {
        ToDoListFunctions empty = new ToDoListFunctions();

        Item firstItem = new Item();
        firstItem.name = "maintenance";
        firstItem.complete = "no";
        firstItem.dueDate = "";
        firstItem.description = "oil change";

        Item secondItem = new Item();
        secondItem.name = "test";
        secondItem.complete = "yes";
        secondItem.dueDate = "2021-12-02";
        secondItem.description = "oil change";

        ToDoListFunctions test = new ToDoListFunctions();
        test.itemList.add(firstItem);
        test.itemList.add(secondItem);

        ToDoListFunctions expected = new ToDoListFunctions();
        expected.itemList.add(secondItem);

        test.displayCompletedTasks(empty.itemList);

        assertEquals(expected.itemList, empty.itemList);
    }

    @Test
    void displayIncompleteTasks() {
        ToDoListFunctions empty = new ToDoListFunctions();

        Item firstItem = new Item();
        firstItem.name = "maintenance";
        firstItem.complete = "no";
        firstItem.dueDate = "";
        firstItem.description = "oil change";

        Item secondItem = new Item();
        secondItem.name = "test";
        secondItem.complete = "yes";
        secondItem.dueDate = "2021-12-02";
        secondItem.description = "oil change";

        ToDoListFunctions test = new ToDoListFunctions();
        test.itemList.add(firstItem);
        test.itemList.add(secondItem);

        ToDoListFunctions expected = new ToDoListFunctions();
        expected.itemList.add(firstItem);

        test.displayIncompleteTasks(empty.itemList);

        assertEquals(expected.itemList, empty.itemList);
    }
}