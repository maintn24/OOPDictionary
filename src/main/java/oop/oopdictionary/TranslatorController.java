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

public class TranslatorController {

    @FXML
    private TextArea targetDoc;

    @FXML
    private TextArea resultDoc;

    @FXML
    private Button addWord;



    @FXML
    public void initialize() {
        targetDoc.setWrapText(true);
        resultDoc.setWrapText(true);
        targetDoc.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && event.isShiftDown()) {
                // Shift + Enter pressed, insert a new line without handling the default behavior
                targetDoc.appendText("\n");
            } else if (event.getCode() == KeyCode.ENTER) {
                // Enter pressed, handle the action (replace with your own logic)
                try {
                    onReceiveWord();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
    @FXML
    protected void onReceiveWord() throws IOException, InterruptedException {
        Translator translator = new Translator();
        String userInput = targetDoc.getText();
        System.out.println(userInput);
        resultDoc.setText(translate("en", "vi", userInput));
    }
}
