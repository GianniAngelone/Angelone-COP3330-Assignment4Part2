/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import java.util.ArrayList;

public class ToDoList {
    private final ArrayList<Item> items = new ArrayList<>();
    public void addItem(Item item) {
        items.add(item); //Add to array list
    }
    public void deleteItem(String description) { //Removing an item by checking if description matches
        for (Item item : items) {
            if (description.equals(item.getDescription())) {
                items.remove(item);
                break;
            }
        }
    }
    public void deleteAllItems() {
        items.clear();
    }
    public ArrayList<Item> getItems() {
        return items; //Returning the array list of items
    }
    public Item getSingleItem(String description) { //Grabbing a single item
        Item requestedItem = new Item();
        for (Item item : items) {
            if (description.equals(item.getDescription())) {
                requestedItem = item;
            }
        }
        return requestedItem;
    }
    public ArrayList<Item> getCompleteItems() { //Loop over items and add to completed items
        ArrayList<Item> completedItems = new ArrayList<>();
        for (Item item : items) {
            if (item.isStatus()) {
                completedItems.add(item);
            }
        }
        return completedItems;
    }
    public ArrayList<Item> getIncompleteItems() { //Add to incomplete arraylist and return
        ArrayList<Item> incompleteItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.isStatus()) {
                incompleteItems.add(item);
            }
        }
        return incompleteItems;
    }
}
