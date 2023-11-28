package oop.oopdictionary.design;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;

public class Dictionary implements Initializable {
    @FXML
    private TextField autoTextField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        String[] possibleWords = {"Hi", "Hello", "Apple", "Bake", "Cake", "Boy", "Arrange", "Cool", "Cola"};

        TextFields.bindAutoCompletion(autoTextField, possibleWords);
    }
}
