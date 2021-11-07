/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    @FXML
    public void changeToLoadPreviousListSceneOnButtonPress() throws IOException {
        Parent loadFileParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoadPreviousList.fxml")));
        Scene loadPrevListScene = new Scene(loadFileParent);

        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.setTitle("Load List");
        window.setScene(loadPrevListScene);
        window.show();
    }

    @FXML
    public void changeToCreateNewListSceneOnButtonPress() throws IOException {
        Parent loadFileParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateNewList.fxml")));
        Scene loadPrevListScene = new Scene(loadFileParent);

        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.setTitle("Create New List");
        window.setScene(loadPrevListScene);
        window.show();
    }

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
