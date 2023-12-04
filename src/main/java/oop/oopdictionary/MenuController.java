package oop.oopdictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private ImageView defaultdict;

    @FXML
    private ImageView defaulttrans;

    @FXML
    private ImageView defaultgame;

    private boolean isButtonClicked = false;
    private Button lastClickedButton;

    private MyDictController dictCtrl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("mydictionary/my-dict.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

        myDictionaryButton.setOnMouseEntered(mouseEvent -> {
            if (!isButtonClicked) {
                myDictionaryButton.setStyle("-fx-background-color: #6a7e78");

            }
        });
        myDictionaryButton.setOnMouseExited(mouseEvent -> {
            if (!isButtonClicked && lastClickedButton != myDictionaryButton) {
                myDictionaryButton.setStyle("-fx-background-color: #6a7e78");
            }
        });
        myDictionaryButton.setOnAction(actionEvent -> {
            if (lastClickedButton != null && lastClickedButton != myDictionaryButton) {
                lastClickedButton.setStyle("-fx-background-color: #6a7e78");

            }

            myDictionaryButton.setStyle("-fx-background-color: #D8E0CE");
            isButtonClicked = true;
            lastClickedButton = myDictionaryButton;


            try {
                switchToDictionary(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        translateButton.setOnMouseEntered(mouseEvent -> {
            if (!isButtonClicked) {
                translateButton.setStyle("-fx-background-color: #6a7e78");
            }
        });
        translateButton.setOnMouseExited(mouseEvent -> {
            if (!isButtonClicked && lastClickedButton != translateButton)  {
                translateButton.setStyle("-fx-background-color: #6a7e78");
            }
        });
        translateButton.setOnAction(actionEvent -> {
            if (lastClickedButton != null && lastClickedButton != translateButton) {
                lastClickedButton.setStyle("-fx-background-color: #6a7e78");
            }
            translateButton.setStyle("-fx-background-color: #EFC8CF");
            isButtonClicked = true;
            lastClickedButton = translateButton;


            try {
                switchToTranslator(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        gameButton.setOnMouseEntered(mouseEvent -> {
            if (!isButtonClicked) {
                gameButton.setStyle("-fx-background-color: #6a7e78");
            }
        });
        gameButton.setOnMouseExited(mouseEvent -> {
            if (!isButtonClicked && lastClickedButton != gameButton) {
                gameButton.setStyle("-fx-background-color: #6a7e78");
            }
        });
        gameButton.setOnAction(actionEvent -> {
            if (lastClickedButton != null && lastClickedButton != gameButton) {
                lastClickedButton.setStyle("-fx-background-color: #6a7e78");
            }
            gameButton.setStyle("-fx-background-color: #D8E0CE");
            isButtonClicked = true;
            lastClickedButton = gameButton;

            try {
                switchToGameManager(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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