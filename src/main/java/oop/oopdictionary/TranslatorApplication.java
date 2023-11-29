package oop.oopdictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TranslatorApplication extends Application {

    private static TranslatorApplication instance;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.primaryStage = stage;

        //dictionary.insertFromFile();
        showTranslator();
    }

    public void showScene() {

    }
    public void showTranslator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("translator.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public TranslatorApplication getInstance() {
        return instance;
    }
    public static void main(String[] args) {
        launch();
    }
}