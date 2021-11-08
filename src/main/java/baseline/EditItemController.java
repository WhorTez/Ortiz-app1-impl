package baseline;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EditItemController {
    Item newItem = new Item();
    ListManager lm = new ListManager();

    @FXML
    private Label errorLabel;
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescription;
    @FXML
    private DatePicker itemDueDate;

    @FXML
    public void editItemInfo(MouseEvent event) throws IOException{
        if(!itemDescription.getText().equals("")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = loader.load();
            MainMenuController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            newItem.name = itemName.getText();
            newItem.description = itemDescription.getText();

            if(itemDueDate.getValue() == null) {
                newItem.dueDate = "";
            } else {
                newItem.dueDate = itemDueDate.getValue().toString();
            }
            newItem.complete = "no";

            lm.tdf.addItem(newItem);
            controller.toDoList.add(newItem);
            controller.lm = lm;
            controller.loadTable(lm);

            stage.show();

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        }else{
            errorLabel.setText("Please enter a description");
        }
    }
    @FXML
    public void showItemInfo(Item selectedItem) {
        itemName.setText(selectedItem.name);
        itemDescription.setText(selectedItem.description);
    }
}
