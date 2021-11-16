/*
 * UCF COP3330 Fall 2021 Assignment 4 Solution
 * Copyright 2021 Gianni Angelone
 */
package ucf.assignments;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelpControl {
    @FXML
    private TextArea helpTextArea;

    public void initialize() {
        String helpText = """
                
                ***NOTE: This is a help window***
                                
                To Do List:
                First an empty table will be displayed.
                You can add an item to the table by clicking the 'Add Item' button, where you can add a due date and
                a description. Click 'OK'.
                You can remove an item from the table by selecting the item and clicking 'Remove Item'.
                To determine a completed status of an item, click 'Change Status' to true=complete, or false=incomplete.
                You can edit an item by selecting an item on the table, and clicking 'Edit Item'.
                - Here you can change the current description or due date. Click 'OK'.
                You can clear all items in the list by clicking 'Clear List'.
                If you would like to clear all current items in the list, click the 'Clear List' button.
                Display Options:
                You can choose display options, by clicking 'Display Options', you can click 'Display Complete',
                'Display Incomplete', or 'Display All'
                You can save a list by clicking on the file drop down and click 'Save List'
                - From here, you can choose where to save the file and what to name it.
                You can load a previously saved list by selecting 'File' drop down clicking 'Load List'.
                - You select a list and click 'Open'.
                         """;

        helpTextArea.setText(helpText);
        helpTextArea.setEditable(false);

    }

}