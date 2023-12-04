package oop.oopdictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

    private static GameApplication instance;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.primaryStage = stage;

        //dictionary.insertFromFile();
        showGameManager();
    }

    public void showScene() {

    }

    public void showGameManager() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-manager.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showWordSortGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("wordsortgame/word-sort1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showQuizGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("quizgame/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public GameApplication getInstance() {
        return instance;
    }
    public static void main(String[] args) {
        launch();
    }
}