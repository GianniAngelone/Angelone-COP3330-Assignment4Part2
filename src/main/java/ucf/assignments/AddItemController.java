/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */
package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {
    @FXML private TextField itemDescriptionTextField;
    @FXML private TextField itemDueDateTextField;
    @FXML private Button addNewItemOkButton;
    @FXML private Button addNewItemCancelButton;
    private Item newItem;
    public void initialize(Item item) {
        this.newItem = item;
    }
    @FXML
    public void addNewItemOkButtonPressed() {
        newItem.setDescription(itemDescriptionTextField.getText()); //Setting the description of the item
        newItem.setDueDate(itemDueDateTextField.getText()); //Setting the due date of the item
        Stage stage = (Stage) addNewItemOkButton.getScene().getWindow(); //Getting the current window
        stage.close();  //Closing the window
    }
    @FXML
    public void addNewItemCancelButtonPressed() {
        Stage stage = (Stage) addNewItemCancelButton.getScene().getWindow();  //Getting the current window
        stage.close(); //Closing the window
    }
}