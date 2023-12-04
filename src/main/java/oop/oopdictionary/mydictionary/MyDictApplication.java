package oop.oopdictionary.mydictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.oopdictionary.DictionaryManagement;

import java.io.IOException;

public class MyDictApplication extends Application {

    private static MyDictApplication instance;
    public DictionaryManagement dictionary = new DictionaryManagement();
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.primaryStage = stage;

        //dictionary.insertFromFile();
        showMyDictionary();
    }

    public void showScene() {

    }
    public void showMyDictionary() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("my-dict.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAddWord() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-word.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showImportFile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("import-file.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public MyDictApplication getInstance() {
        return instance;
    }
    public static void main(String[] args) {
        launch();
    }
}