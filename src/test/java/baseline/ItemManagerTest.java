package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    @Test
    void writeToFile() {
        Item firstItem = new Item();
        firstItem.name = "maintenance";
        firstItem.complete = "false";
        firstItem.dueDate = "";
        firstItem.description = "math";

        Item secondItem = new Item();
        secondItem.name = "maintenance";
        secondItem.complete = "false";
        secondItem.dueDate = "";
        secondItem.description = "oil change";

        ListManager test = new ListManager();
        test.tdf.itemList.add(firstItem);
        test.tdf.itemList.add(secondItem);

        test.writeToFile("input/testWriteToFile.txt", test);

        assertEquals(2, test.tdf.itemList.size());
    }

    @Test
    void loadToDoListTest() {
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

        ListManager expected = new ListManager();
        expected.tdf.itemList.add(firstItem);
        expected.tdf.itemList.add(secondItem);

        ListManager test = new ListManager();
        test = test.loadToDoList("input/loadToDoListTest.txt");



        assertEquals(expected.tdf.itemList.get(0).name, test.tdf.itemList.get(0).name);
        assertEquals(expected.tdf.itemList.get(1).description, test.tdf.itemList.get(1).description);
    }

    @Test
    void getFileLocation() {
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

        ListManager test = new ListManager();
        test.tdf.itemList.add(firstItem);
        test.tdf.itemList.add(secondItem);
        test.fileLocation = "input";

        assertEquals("input", test.getFileLocation());
    }

    @Test
    void getFileName() {
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

        ListManager test = new ListManager();
        test.tdf.itemList.add(firstItem);
        test.tdf.itemList.add(secondItem);
        test.tdf.title = "itemListOne";

        assertEquals("itemListOne", test.getFileName());
    }
}