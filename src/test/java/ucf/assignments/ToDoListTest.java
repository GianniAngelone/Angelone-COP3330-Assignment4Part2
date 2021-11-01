/*
 * UCF COP3330 Fall 2021 Assignment 4 Solution
 * Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoListTest {
    @Test
    @DisplayName("Ensure 100 items can be added")
    public void test_ToDoList_100_items() {
        ToDoList testMe = new ToDoList();
        for(int i = 0; i <100; i++) {
            Item item = new Item();
            testMe.addItem(item);
        }
        assertEquals(100, testMe.getItems().size());
    }
    @Test
    @DisplayName("Test deleting an item")
    void test_delete_correct_item() {
        ToDoList testMe = new ToDoList();
        Item item1 = new Item();
        item1.setDescription("Item Description");
        Item item2 = new Item();
        item2.setDescription("Testing delete");
        testMe.addItem(item1);
        testMe.addItem(item2);
        testMe.deleteItem("Testing delete");
        assertEquals(1, testMe.getItems().size());
    }
    @Test
    @DisplayName("Testing deleting all items from list")
    public void test_deleteAllItems_from_list() {
        ToDoList testMe = new ToDoList();
        for(int i = 0; i < 10; i++) { //Add items first
            Item item = new Item();
            item.setDescription("Item "+ (i+1));
            item.setDueDate("2021-07-08");
            item.setStatus(i % 2 == 0);
            testMe.addItem(item);
        }
        testMe.deleteAllItems(); //Delete items, then call list to see if it is empty
        ArrayList<Item> actual = testMe.getItems();
        assertThat(actual, IsEmptyCollection.empty());
    }
    @Test
    @DisplayName("Acquire a single item") //By checking if descriptions match
    void getSingleItem() {
        ToDoList testMe = new ToDoList();
        for(int i = 0; i < 3; i++) {
            Item item = new Item();
            item.setDescription("Item "+ i);
            testMe.addItem(item);
        }
        Item actual = testMe.getSingleItem("Item 2");
        String expected = "Item 2";
        assertEquals(expected, actual.getDescription());
    }
    @Test
    @DisplayName("Testing all items returned (getItems)")
    public void test_getItems_returns_list() {
        ToDoList testMe = new ToDoList();
        StringBuilder actual = new StringBuilder();
        for(int i = 0; i < 10; i++) { //Add to list
            Item item = new Item();
            item.setDescription("Item "+ (i+1));
            item.setDueDate("2021-07-08");
            item.setStatus(i % 2 == 0);
            testMe.addItem(item);
        }
        for(Item item : testMe.getItems()) { //Build string of items
            actual.append(String.format("%s, %s, %s%n", item.getDescription(), item.getDueDate(), item.isStatus()));
        }
        StringBuilder expected = new StringBuilder();
        for(int i = 0; i < 10; i++) { //Add to string
            Item item = new Item();
            item.setDescription("Item "+ (i+1));
            item.setDueDate("2021-07-08");
            item.setStatus(i % 2 == 0);
            expected.append(String.format("%s, %s, %s%n", item.getDescription(), item.getDueDate(), item.isStatus()));
        }
        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    @DisplayName("Testing if incomplete items are returned")
    public void test_getIncompleteItems_returns_list() {
        ToDoList testMe = new ToDoList();
        ArrayList<Item> expected = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            Item item = new Item();
            if(i % 2 == 0) {
                item.setDescription("Complete");
                item.setStatus(true);
            } else {
                item.setDescription("Incomplete");
                expected.add(item);
            }
            testMe.addItem(item);
        }
        ArrayList<Item> actual = testMe.getIncompleteItems();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Testing if completed list is returned")
    public void test_getCompleteItems_returns_list() {
        ToDoList testMe = new ToDoList();
        ArrayList<Item> expected = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            Item item = new Item();
            if(i % 2 == 0) {
                item.setDescription("Complete");
                item.setStatus(true);
                expected.add(item);
            } else {
                item.setDescription("Incomplete");
            }
            testMe.addItem(item);
        }
        ArrayList<Item> actual = testMe.getCompleteItems();
        assertEquals(expected, actual);
    }
}