/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoadPreviousListController {
    ListManager lm = new ListManager();
    @FXML
    private Button confirmButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField filePath;
    @FXML
    private Label label;

    @FXML
    public String getFilePath(MouseEvent event){
        if(!filePath.getText().equals("")) {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        }else{
            label.setText("Enter a valid file path");
        }
        lm.load
    }
}
