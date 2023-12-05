package oop.oopdictionary.mydictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import oop.oopdictionary.Main;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddWordController {

    @FXML
    private AnchorPane contentArea;
    @FXML
    private Button finish;

    @FXML
    private TextField targetWord;

    @FXML
    private TextField explanation;

    private String target;
    private String explain;

    Main app = new Main();

    public void initialize() throws FileNotFoundException {

        finish.setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        target = targetWord.getText();
                        explain = explanation.getText();
                        try {
                            switchToDictionary();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        app.dictionary.addWord(target, explain);
                        System.out.println("Add success");
                        System.out.println(target + " " + explain);

                    }
                }
        );
    }


    @FXML
    private void switchToDictionary() throws IOException {
        //app.getInstance().showMyDictionary();
        Parent fxml = FXMLLoader.load(getClass().getResource("my-dict.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}

