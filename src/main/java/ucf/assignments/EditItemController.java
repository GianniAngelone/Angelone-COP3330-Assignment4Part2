/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditItemController {
    @FXML
    private TextField itemDescriptionTextField;
    @FXML
    private TextField itemDueDateTextField;
    @FXML
    private Button editItemOkButton;
    @FXML
    private Button editItemCancelButton;
    private Item item;
    public void initialize(Item item) {
        this.item = item; //Assigning the passed item
        itemDescriptionTextField.setText(item.getDescription()); //Setting the description
        itemDueDateTextField.setText(item.getDueDate()); //Setting the due date
    }
    @FXML
    public void editItemOkButtonPressed() {
        item.setDescription(itemDescriptionTextField.getText()); //Setting the description
        item.setDueDate(itemDueDateTextField.getText()); //Setting the due date
        Stage stage = (Stage) editItemOkButton.getScene().getWindow(); //Getting the current window
        stage.close(); //Closing the window
    }
    @FXML
    public void editItemCancelButtonPressed() {
        Stage stage = (Stage) editItemCancelButton.getScene().getWindow(); //Get the current window
        stage.close(); //Closing the window
    }
}
