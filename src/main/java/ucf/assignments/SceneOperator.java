/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneOperator {
    private FXMLLoader loader;
    @FXML
    public Parent readyScene(Scenes view) {
        Parent page = null;
        try {
            loader = new FXMLLoader(getClass().getResource(view.getFileName()));
            page = loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return page;
    }
    @FXML
    public void popUpScene(String title, Parent page) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(page));
        stage.showAndWait();
    }
    public FXMLLoader getLoader() {
        return loader;
    }

}
