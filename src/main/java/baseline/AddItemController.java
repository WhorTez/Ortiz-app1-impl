package baseline;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AddItemController {
    ListManager lm = new ListManager();
    Item newItem = new Item();

    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDesctiption;
    @FXML
    private DatePicker itemDueDate;

    @FXML
    public void closeWindowOnExitPress(MouseEvent event){
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    public void getItemInfo(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = loader.load();
        MainMenuController controller = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        newItem.itemName = itemName.getText();
        newItem.description = itemDesctiption.getText();
        newItem.dueDate = itemDueDate.getValue().toString();
        newItem.complete = "false";

    }
}
