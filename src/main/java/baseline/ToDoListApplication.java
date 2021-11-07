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
    public void start (Stage stage) throws Exception{

        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("baseline.MainMenu.fxml")));
        Scene scene = new Scene(root); // attaches scene graph to scene
        stage.setTitle("ToDo Lists");
        stage.setScene(scene); //Attaches scene to stage
        stage.show(); //display the stage
    }

    public static void main (String[]args){
        launch(args);
    }

    public ItemManager saveToDoLists () {
        //creates an empty taskManager
        // will only add TDL's with fields set to true
        // will return the created taskManager so it can be saved
        //   return null;

        return null;
    }


    public void writeToFile (ItemManager selectedLists){
        //writes the manager created in function above and loops
        //its items(in this case toDoLists) and will print them in seperate lines
    }

    public ItemManager loadingLists () {
        //loads the file that contains a taskManager manager
        //reads the text file and populates a new manager
        //returns newly made manager
        return null;
    }
}
