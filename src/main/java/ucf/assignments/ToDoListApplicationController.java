/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.util.ArrayList;

public class ToDoListApplicationController {
    @FXML
    private TableView<Item> toDoListItemsView;
    @FXML
    private TableView.TableViewSelectionModel<Item> selection;
    private ToDoList toDoList = new ToDoList();
    private final TableOperator tableOperator = new TableOperator();
    private final SceneOperator sceneOperator = new SceneOperator();
    private final FileChooser fileChooser = new FileChooser();
    private final FileParser fileParser = new FileParser();
    public void initialize() {
        //tell the table operator which table to operate on
        tableOperator.setTable(toDoListItemsView);
        tableOperator.buildTable(); //Build the table
        toDoListItemsView = tableOperator.getTable(); //Getting the table
        selection = tableOperator.getSelection(); //Selecting model
    }
    //Application Operations
    @FXML
    public void saveListButtonPressed() {
        Window window = readyFileChooser("Save List"); //saveCurrentListButton
        File file = fileChooser.showSaveDialog(window); //File object to hold
        fileParser.saveToDoList(toDoList, file); //Saving the list
    }
    @FXML
    public void loadListButtonPressed() {
        toDoListItemsView.getItems().clear(); //Clear items
        Window window = readyFileChooser("Load List");
        File file = fileChooser.showOpenDialog(window); //File object to hold
        toDoList = fileParser.loadToDoList(file); //Loading the list
        tableOperator.setTable(toDoListItemsView); //Setting the table
        tableOperator.loadTable(toDoList); //Adding list items
    }
    @FXML
    public void helpPressed() {
        Parent page = sceneOperator.readyScene(Scenes.HELP);
        sceneOperator.popUpScene("Help!", page); //Display the help page
    }
    //list operations
    @FXML
    public void addItemButtonPressed() {
        Item newItem = new Item();
        Parent page = sceneOperator.readyScene(Scenes.ADD); //AddItemScene
        AddItemController addItemController = sceneOperator.getLoader().getController(); //Getting the controller
        addItemController.initialize(newItem);
        sceneOperator.popUpScene("Add Item", page); //Pop up window
        toDoList.addItem(newItem); //Add new item
        toDoListItemsView.getItems().add(newItem); //Refresh
    }
    @FXML
    public void removeItemButtonPressed() {
        Item selectedItem = selection.getSelectedItem(); //Get selected item
        toDoList.deleteItem(selectedItem.getDescription()); //Remove from toDoList
        toDoListItemsView.getItems().removeAll(selectedItem); //Remove from table
    }
    @FXML
    public void clearListButtonPressed() {
        toDoListItemsView.getItems().clear(); //Clear table
        toDoList.deleteAllItems(); //Clear toDoList
    }
    //Item Operations
    @FXML
    public void changeStatusButtonPressed() {
        Item selectedItem = selection.getSelectedItem(); //Getting selected item
        toDoList.deleteItem(selectedItem.getDescription()); //Remove previous ite
        toDoListItemsView.getItems().clear(); //Remove selected item from view
        selectedItem.setStatus(!selectedItem.isStatus()); //Update status
        toDoList.addItem(selectedItem); //Add item to toDoList
        tableOperator.setTable(toDoListItemsView); //Setting the table
        tableOperator.loadTable(toDoList); //Add updated item
    }

    @FXML
    public void editItemButtonPressed() {
        Item selectedItem = selection.getSelectedItem(); //Getting the selected item
        toDoList.deleteItem(selectedItem.getDescription()); //Removing it from the to do list
        toDoListItemsView.getItems().removeAll(selectedItem); //Removing it from the table view
        Parent page = sceneOperator.readyScene(Scenes.EDIT); //Prepare item scene
        EditItemController editItemController = sceneOperator.getLoader().getController(); //Controller for EditItemScene
        editItemController.initialize(selectedItem); //Initialize controller
        sceneOperator.popUpScene("Edit Item", page); //Pop up window
        toDoList.addItem(selectedItem); //Adding updated item to the list
        toDoListItemsView.getItems().add(selectedItem);  //Updated item to table view
    }
    //Display Operations
    @FXML
    public void displayAllButtonPressed() {
        toDoListItemsView.getItems().clear(); //Remove all current items from table
        tableOperator.setTable(toDoListItemsView); //Setting table
        tableOperator.loadTable(toDoList); //Add items from list to table
    }
    @FXML
    public void displayCompleteButtonPressed() {
        ArrayList<Item> completedList = toDoList.getCompleteItems(); //Calling getCompletedItems for to do list
        toDoListItemsView.getItems().clear(); //Remove from table
        tableOperator.setTable(toDoListItemsView); //Setting the table
        tableOperator.loadTable(completedList); //Add items to table
    }
    @FXML
    public void displayIncompleteButtonPressed() {
        ArrayList<Item> incompleteList = toDoList.getIncompleteItems(); //Calling getIncompleteItems for todoList
        toDoListItemsView.getItems().clear(); //Remove from table
        tableOperator.setTable(toDoListItemsView); //Setting the table
        tableOperator.loadTable(incompleteList); //Add items to table
    }
    private Window readyFileChooser(String title) {
        Window window = toDoListItemsView.getScene().getWindow(); //Preparing
        fileChooser.setTitle(title); //Setting title
        //add appropriate extensions to be displayed
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt", "*.txt"),
                new FileChooser.ExtensionFilter("*.json", "*.json"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );
        return window; //Return FileChooser
    }
}