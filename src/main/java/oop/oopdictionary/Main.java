package oop.oopdictionary;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //chạy chương trình full ở đây
    private static Main instance;
    public DictionaryManagement dictionary = new DictionaryManagement();
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.primaryStage = stage;

        //dictionary.insertFromFile();
        showMenu();

    }

    public void showMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-bar.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Main getInstance() {
        return instance;
    }
    public static void main(String[] args) {
        launch();
    }
}

