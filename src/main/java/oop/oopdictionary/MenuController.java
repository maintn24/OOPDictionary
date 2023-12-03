package oop.oopdictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import oop.oopdictionary.mydictionary.MyDictController;
//import oop.oopdictionary.wordsortgame.WordSortController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {
    @FXML
    private Button myDictionaryButton;
    @FXML
    private Button translateButton;
    @FXML
    private Button gameButton;

    @FXML
    private StackPane contentArea;

    private MyDictController dictCtrl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void switchToDictionary(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("mydictionary/my-dict.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    public void switchToTranslator(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("translator.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    public void switchToGameManager(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("game-manager.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

}