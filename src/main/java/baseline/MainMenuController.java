/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Duane Ortiz
 */
package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable{
    ObservableList<Item> toDoList = FXCollections.observableArrayList();

    ListManager lm = new ListManager();

    @FXML
    private TextField fileLocationAndName;
    @FXML
    public TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> completionColumn;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, String> dueDateColumn;
    @FXML
    private RadioButton showAllItems;
    @FXML
    private RadioButton showIncompleteItems;
    @FXML
    private RadioButton showCompletedItems;

    @FXML
    public void changeItemViewOnRadioToggle(){
        ListManager currentDisplay = new ListManager();
        if(showAllItems.isSelected()){
            showCompletedItems.selectedProperty().set(false);
            showIncompleteItems.selectedProperty().set(false);
            loadTable(lm);
        }
        if(showCompletedItems.isSelected()){
            showAllItems.selectedProperty().set(false);
            showIncompleteItems.selectedProperty().set(false);
            lm.tdf.displayCompletedTasks(currentDisplay.tdf.itemList);
            loadTable(currentDisplay);
        }
        if(showIncompleteItems.isSelected()){
            showAllItems.selectedProperty().set(false);
            showCompletedItems.selectedProperty().set(false);
            lm.tdf.displayIncompleteTasks(currentDisplay.tdf.itemList);
            loadTable(currentDisplay);
        }
    }

    @FXML
    public void toggleCompletionOnButtonPress(){
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(lm.tdf.itemList.contains(selectedItem)){
            int indexOfItem = lm.tdf.itemList.indexOf(selectedItem);
            lm.tdf.itemList.get(indexOfItem).ChangeComplete();
            loadTable(lm);
        }
    }

    @FXML
    public void removeItemFromTable() {
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (lm.tdf.itemList.contains(selectedItem)) {
            toDoList.remove(selectedItem);
            lm.tdf.itemList.remove(selectedItem);
            loadTable(lm);
            System.out.print(lm.tdf.itemList.get(0).name);
        }
    }

    @FXML
    public void clearAllItemsFromTable(){
        tableView.getItems().removeAll(toDoList);
        toDoList.removeAll();
        lm.tdf.itemList = lm.tdf.clearAll();
        loadTable(lm);
    }

    @FXML
    public void saveListToTextFile(){
        lm.writeToFile("output/"+ fileLocationAndName.getText() +".txt", lm);
        fileLocationAndName.clear();
        fileLocationAndName.setPromptText("Enter the file location as well as the name of the file: ");
    }

    @FXML
    public void popupAddItemSceneOnButtonPress() throws IOException{
        List<Item> currentItems = tableView.getItems();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddItem.fxml"));
        Parent addItemParent = loader.load();
        Scene addItemScene = new Scene(addItemParent);
        AddItemController add = loader.getController();

        add.lm.tdf.itemList = currentItems;
        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Add New Item");
        stage.setScene(addItemScene);
        stage.show();
    }

    @FXML
    public void popupEditItemSceneOnButtonPress() throws IOException {
        List<Item> currentItems = tableView.getItems();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
        Parent editItemParent = loader.load();
        Scene editItemScene = new Scene(editItemParent);
        EditItemController editItemController = loader.getController();

        Item selectedItem = tableView.getSelectionModel().getSelectedItem();

        editItemController.showItemInfo(selectedItem);
        currentItems.remove(selectedItem);
        editItemController.lm.tdf.itemList = currentItems;

        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Edit item");
        stage.setScene(editItemScene);
        stage.show();
    }


    @FXML
    public void changeToLoadFileSceneOnButtonPress() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoadPreviousList.fxml"));
        Parent loadPrevListParent = loader.load();
        Scene loadPrevListScene = new Scene(loadPrevListParent);

        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Load List");
        stage.setScene(loadPrevListScene);
        stage.show();
    }

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        completionColumn.setCellValueFactory(new PropertyValueFactory<>("Complete?"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        tableView.setItems(toDoList);
    }

    @FXML
    public void loadTable(ListManager lm){
        tableView.getItems().clear();
        toDoList.addAll(lm.tdf.itemList);
        tableView.setItems(toDoList);
    }
}
