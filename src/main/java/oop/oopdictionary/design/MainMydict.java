package oop.oopdictionary.design;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMydict extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMydict.class.getResource("importdic.fxml"));
        Scene scene;
        scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

