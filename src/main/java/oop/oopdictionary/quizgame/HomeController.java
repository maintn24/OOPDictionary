package oop.oopdictionary.quizgame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeController {

    @FXML
    private AnchorPane contentArea;
    @FXML
    private Button playquizbtn;

    @FXML
    private void initialize() {

        playquizbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    switchToQuiz();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//                try {
//                    Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//                    thisstage.close();
//
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("quiz.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = new Stage();
//                    stage.setScene(scene);
//                    //stage.initStyle(StageStyle.TRANSPARENT);
//                    scene.setFill(Color.TRANSPARENT);
//                    stage.show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }



            }
        });

    }

    @FXML
    private void switchToQuiz() throws IOException {
        //app.getInstance().showQuizGame();
        Parent fxml = FXMLLoader.load(getClass().getResource("quiz.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

}
