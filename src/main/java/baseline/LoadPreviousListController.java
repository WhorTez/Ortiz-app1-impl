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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class LoadPreviousListController {
    ListManager lm = new ListManager();

    @FXML
    private TextField filePath;
    @FXML
    private Label label;

    @FXML
    public void getFilePath(MouseEvent event) throws IOException {
        if(!filePath.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = loader.load();
            MainMenuController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            controller.lm = lm.loadToDoList(filePath.getText());
            controller.loadTable(lm.loadToDoList(filePath.getText()));

            stage.show();

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        } else {
            label.setText("Enter a valid file path");
        }
    }
}
