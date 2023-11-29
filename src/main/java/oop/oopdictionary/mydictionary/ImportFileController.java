package oop.oopdictionary.mydictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class ImportFileController {
    @FXML
    Button importButton;

    @FXML
    TextField file;

    MyDictApplication app = new MyDictApplication();

    public void initialize() throws FileNotFoundException {

        importButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        String fileName = file.getText();
                        try {
                            app.dictionary.insertFromFile(fileName);
                            System.out.println("File inserted");
                            switchToDictionary();
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
    }


    @FXML
    private void switchToDictionary() {
        app.getInstance().showMyDictionary();
    }
}

