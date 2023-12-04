package oop.oopdictionary.mydictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class AddWordController {
    @FXML
    Button finish;

    @FXML
    TextField targetWord;

    @FXML
    TextField explanation;

    String target;
    String explain;

    MyDictApplication app = new MyDictApplication();

    public void initialize() throws FileNotFoundException {

        finish.setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        target = targetWord.getText();
                        explain = explanation.getText();
                        switchToDictionary();
                        app.dictionary.addWord(target, explain);
                        System.out.println("Add success");
                        System.out.println(target + " " + explain);

                    }
                }
        );
    }


    @FXML
    private void switchToDictionary() {

        app.getInstance().showMyDictionary();
    }
}

