/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;


public class ToDoListApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        Scene scene = new Scene(root); // attaches scene graph to scene
        stage.setTitle("What's up Doc?");
        stage.setScene(scene); //Attaches scene to stage
        stage.show(); //display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}