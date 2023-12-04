package oop.oopdictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import oop.oopdictionary.mydictionary.MyDictApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static oop.oopdictionary.Translator.translate;

public class GameManagerController implements Initializable{
    @FXML
    private AnchorPane contentArea;

    @FXML
    private Button wordSort;

    @FXML
    private Button quiz;

    Main app = new Main();

    @FXML
    private void switchToWordSortGame() throws IOException {
        //app.getInstance().showWordSortGame();
        Parent fxml = FXMLLoader.load(getClass().getResource("wordsortgame/word-sort1.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void switchToQuizGame() throws IOException {
        //app.getInstance().showQuizGame();
        Parent fxml = FXMLLoader.load(getClass().getResource("quizgame/home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
