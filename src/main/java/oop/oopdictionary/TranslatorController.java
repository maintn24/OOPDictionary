package oop.oopdictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

import java.io.IOException;

import static oop.oopdictionary.Translator.translate;

public class TranslatorController {
    @FXML
    private Button speaker1;

    @FXML
    private Button speaker2;
    @FXML
    private Button lang1;
    @FXML
    private Button lang2;
    @FXML
    private Button changeLang;

    @FXML
    private TextArea targetDoc;

    @FXML
    private TextArea resultDoc;

    @FXML
    private Button addWord;

    private String language1 = "en";
    private String language2 = "vi";

    @FXML
    public void initialize() {
        lang1.setText("ENG");
        lang2.setText("VIE");
        targetDoc.setWrapText(true);
        resultDoc.setWrapText(true);
        resultDoc.setEditable(false);
        targetDoc.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && event.isShiftDown()) {
                // Shift + Enter pressed, insert a new line without handling the default behavior
                targetDoc.appendText("\n");
            } else if (event.getCode() == KeyCode.ENTER) {
                // Enter pressed, handle the action (replace with your own logic)
                try {
                    onReceiveWord();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
    @FXML
    protected void onReceiveWord() throws IOException, InterruptedException {
        //Translator translator = new Translator();
        String userInput = targetDoc.getText();
        System.out.println(userInput);
        resultDoc.setText(translate(language1, language2, userInput));
    }

    @FXML
    protected void changeLanguage() throws IOException {
        String tmp = lang1.getText();
        lang1.setText(lang2.getText());
        lang2.setText(tmp);

        tmp = language1;
        language1 = language2;
        language2 = tmp;

        //Translator translator = new Translator();
        String userInput = targetDoc.getText();
        System.out.println(userInput);
        resultDoc.setText(translate(language1, language2, userInput));
    }

    @FXML
    public void pronounceEng(ActionEvent event) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice audio = VoiceManager.getInstance().getVoice("kevin16");
        if (audio != null) {
            audio.allocate();
            audio.speak(targetDoc.getText());
        } else throw new IllegalStateException("Cannot find voice: kevin16");
    }
    @FXML
    public void pronounceVie(ActionEvent event) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice audio = VoiceManager.getInstance().getVoice("kevin16");
        if (audio != null) {
            audio.allocate();
            audio.speak(resultDoc.getText());
        } else throw new IllegalStateException("Cannot find voice: kevin16");
    }
}