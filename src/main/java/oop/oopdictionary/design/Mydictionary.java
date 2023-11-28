package oop.oopdictionary.design;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class Mydictionary {


    @FXML
    private AnchorPane importdict1;



    @FXML
    public void importdict(ActionEvent event) throws IOException {
        new SwitchScene(importdict1, "importdic.fxml");
    }

    public void addword(ActionEvent event) throws IOException {
        new SwitchScene(importdict1, "addword.fxml");
    }





        //        primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader.load());

}
