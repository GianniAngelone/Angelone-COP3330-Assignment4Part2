/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

public class TableOperator {

    private TableView<Item> table;
    private TableView.TableViewSelectionModel<Item> selection;

    public void buildTable() {
        TableColumn<Item, String> column1 = new TableColumn<>("Description"); //Column 1
        column1.setPrefWidth(225);
        column1.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn<Item, String> column2 = new TableColumn<>("Due Date"); //Column 2
        column2.setPrefWidth(100);
        column2.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        TableColumn<Item, String> column3 = new TableColumn<>("Complete?"); //Column 3
        column3.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setPlaceholder(new Label("No tasks to display"));
        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        selection = table.getSelectionModel();
    }
    public void setTable(TableView<Item> table) {
        this.table = table;
    }
    public TableView<Item> getTable() {
        return table;
    }
    public TableView.TableViewSelectionModel<Item> getSelection() {
        return selection;
    }
    public void loadTable(ToDoList toDoList) {
        for (Item item : toDoList.getItems()) { //Loop every item and add it to table
            table.getItems().add(item);
        }
    }
    public void loadTable(ArrayList<Item> list) {
        for (Item item : list) { //Loop every item and add it to table
            table.getItems().add(item);
        }
    }
}
