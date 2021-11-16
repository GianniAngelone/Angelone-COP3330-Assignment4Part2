/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

public enum Scenes {
    MAIN("ToDoListApplication.fxml"),
    ADD("AddNewItemScene.fxml"),
    EDIT("EditItemScene.fxml"),
    HELP("HelpScene.fxml");

    private final String fileName;

    Scenes(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}