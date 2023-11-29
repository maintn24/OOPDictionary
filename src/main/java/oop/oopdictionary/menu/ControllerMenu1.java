package oop.oopdictionary.menu;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerMenu1 implements Initializable {

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private AnchorPane slidepane;

    @FXML
    private JFXButton menu1;

    @FXML
    private JFXButton menu2;

    @FXML
    private StackPane contentArea;

    @FXML
    private void run2(MouseEvent event) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(slidepane);

        translateTransition.setToX(-285);
        translateTransition.play();

        slidepane.setTranslateX(0);

        translateTransition.setOnFinished(actionEvent -> {
            menu1.setVisible(true);
            menu2.setVisible(false);
        });
    }

    @FXML
    private void run1(MouseEvent event) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(slidepane);

        translateTransition.setToX(0);
        translateTransition.play();

        slidepane.setTranslateX(-285);

        translateTransition.setOnFinished(actionEvent -> {
            menu1.setVisible(false);
            menu2.setVisible(true);
        });
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slidepane.setTranslateX(-285);
        menu1.setVisible(true);
        menu2.setVisible(false);


//        try {
//            Parent fxml = FXMLLoader.load(getClass().getResource("folderpane/dictionary.fxml"));
//            contentArea.getChildren().removeAll();
//            contentArea.getChildren().setAll(fxml);
//        } catch (IOException exception) {
//            Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null,exception);
//        }
    }


    public void dict(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("dictionary.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void mydict(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("mydictionary.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void trans(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("translate.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }


    public void game(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("game.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }


}
