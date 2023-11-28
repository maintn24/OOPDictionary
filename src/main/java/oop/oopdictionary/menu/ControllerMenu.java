package oop.oopdictionary.menu;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMenu implements Initializable {

    @FXML
    private AnchorPane slidepane;

    @FXML
    private JFXButton menu1;

    @FXML
    private JFXButton menu2;

    @FXML
    private void run1(MouseEvent event) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(slidepane);

        translateTransition.setToX(-281);
        translateTransition.play();

        slidepane.setTranslateX(0);

        translateTransition.setOnFinished(actionEvent -> {
            menu1.setVisible(false);
            menu2.setVisible(true);
        });
    }

    @FXML
    private void run2(MouseEvent event) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(slidepane);

        translateTransition.setToX(0);
        translateTransition.play();

        slidepane.setTranslateX(-281);

        translateTransition.setOnFinished(actionEvent -> {
            menu1.setVisible(false);
            menu2.setVisible(true);
        });
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slidepane.setTranslateX(-281);
        menu1.setVisible(false);
        menu2.setVisible(true);
    }

}
