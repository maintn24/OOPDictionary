package oop.oopdictionary.mydictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ImportFileController {
    @FXML
    private AnchorPane contentArea;

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
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
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

