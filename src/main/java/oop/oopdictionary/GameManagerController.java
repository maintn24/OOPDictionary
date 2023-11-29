package oop.oopdictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import oop.oopdictionary.mydictionary.MyDictApplication;

import java.io.IOException;

import static oop.oopdictionary.Translator.translate;

public class GameManagerController {
    @FXML
    private Button wordSort;

    @FXML
    private Button quiz;

    GameApplication app = new GameApplication();
    @FXML
    public void initialize() {

    }

    @FXML
    private void switchToWordSortGame() {
        app.getInstance().showWordSortGame();
    }

    @FXML
    private void switchToQuizGame() {
        app.getInstance().showQuizGame();
    }
}
