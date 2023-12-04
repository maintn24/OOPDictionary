package oop.oopdictionary.mydictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import oop.oopdictionary.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyDictController implements Initializable {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private TextField targetWord;

    @FXML
    private Text explanation;

    @FXML
    private Button addWord;

    @FXML
    private Button deleteWord;

    @FXML
    private Button importFile;

    @FXML
    private Button exportFile;

    String target;

    Main app = new Main();

    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println("Controller initialized");
//        //String[] possibleWords = app.dictionary.printAll();
//        //System.out.println(Arrays.toString(possibleWords));
//        String[] possibleWords = {"Hi", "Hello", "Apple", "Bake", "Cake", "Boy", "Arrange", "Cool", "Cola"};
//        //TextFields.bindAutoCompletion(targetWord, possibleWords);
//        TextFields.bindAutoCompletion(targetWord, possibleWords);

        deleteWord.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        target = targetWord.getText();
                        app.dictionary.removeWord(target);
                        System.out.println("Delete success");
                        explanation.setText(null);
                        System.out.println(target + " deleted");

                    }
                }
        );

//        addWord.setOnAction(
//                new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent e) {
//                        try {
//                            //menu.showAddWord(e);
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    }
//                }
//        );

    }
    @FXML
    protected void onReceiveWord() {
        String userInput = targetWord.getText();
        System.out.println(userInput);
        explanation.setText(app.dictionary.dictionaryLookUp(userInput));
    }

    @FXML
    private void switchToAddWord() throws IOException {
        //app.getInstance().showAddWord();
        Parent fxml = FXMLLoader.load(getClass().getResource("add-word.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }

    @FXML
    private void switchToImportFile() throws IOException {
        //app.getInstance().showImportFile();
        Parent fxml = FXMLLoader.load(getClass().getResource("import-file.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }



}