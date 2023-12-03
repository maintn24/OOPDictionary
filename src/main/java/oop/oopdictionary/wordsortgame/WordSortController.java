package oop.oopdictionary.wordsortgame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import oop.oopdictionary.GameApplication;


import java.io.IOException;
import java.net.URL;
import java.util.*;


public class WordSortController implements Initializable {

    @FXML
    private AnchorPane gameArea;

    @FXML
    private Label unsortedText;

    @FXML
    private TextField answerText;

    @FXML
    private Label notiText;

    @FXML
    private Button finishedButton;

    @FXML
    private Label scoreText;

    @FXML
    private Label question;

    public List<String> wordDone = new ArrayList<>();
    public List<String> wordList = new ArrayList<String>();

    public String answerWord;
    public String userWord = "";
    public int totalOfQuestion;
    public int currentQuestion = 0;
    public int totalScore = 0;
    final private int score = 10;



    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetGame();
        answerText.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        userWord = answerText.getText();
                        System.out.println("Answer received");
                        if(checkAns(userWord)) {
                            totalScore += score;
                            notiText.setText("Correct");
                        } else notiText.setText("Wrong");
                        onGenerateWord();

                    }
                }
        );

    }

    @FXML
    public void resetGame() {
        //app.getInstance().showMyDictionary();
//        InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream("wort-sort1.fxml");
//
//        if (fxmlStream == null) {
//            throw new IOException("FXML file not found");
//        }
//
//        Parent fxml = new FXMLLoader().load(fxmlStream);

//        Parent fxml = FXMLLoader.load(getClass().getResource("word-sort1.fxml"));
//        gameArea.getChildren().removeAll();
//        gameArea.getChildren().setAll(fxml);

        finishedButton.setVisible(false);
        unsortedText.setText(null);
        notiText.setText(null);
        answerText.setVisible(true);
        scoreText.setVisible(true);
        question.setVisible(true);
        totalOfQuestion = 0;
        currentQuestion = 0;
        totalScore = 0;
        wordDone.clear();
        wordList.clear();
        generateWordList();
        System.out.println("List Generated");
        onGenerateWord();


    }



    @FXML
    protected void onGenerateWord() {

        if(totalOfQuestion == 0) { //game end
            //show Score;
            String s = String.valueOf(totalScore);
            notiText.setTextFill(Paint.valueOf("Green"));;
            notiText.setText("Your score is " + s);

            System.out.println("Game end");
            unsortedText.setText(null);

            finishedButton.setVisible(true);

            answerText.setVisible(false);
            scoreText.setVisible(false);
            question.setVisible(false);
        } else {

            answerText.setText(null);

            answerWord = randomWord(wordList,wordDone);
            System.out.println(answerWord);
            String s = generateLetters(answerWord).toString();
            s = String.valueOf(toString(generateLetters(answerWord)));
            unsortedText.setText(s);
            totalOfQuestion--;
            currentQuestion++;
        }
        scoreText.setText("Score: " + String.valueOf(totalScore));
        question.setText("Question " + String.valueOf(currentQuestion));

    }



    @FXML
    protected void onReceiveInput() {
        userWord = answerText.getText();
        System.out.println(userWord);
    }

    private void generateWordList() {
        wordList.add("hello");
        wordList.add("banana");
        wordList.add("orange");
        wordList.add("apple");
        totalOfQuestion = wordList.size();
    }


    public String randomWord(List<String> wordList, List<String> wordDone) {
        int randIndex = (int) (Math.random() * wordList.size());
        String word = wordList.get(randIndex);
        wordDone.add(word);
        wordList.remove(word);
        //System.out.println(word);
        //System.out.println("There are " + wordList.toString());
        wordDone.add(word);
        return word;
    }

    private ArrayList<Character> generateLetters(String word){
        ArrayList<Character> unsortedWord = new ArrayList<Character>();
        for(int i = 0; i< word.length(); i++){
            Character c = word.charAt(i);
            unsortedWord.add(c);
        }
        Collections.shuffle(unsortedWord);

        return unsortedWord;
        //System.out.println(unsortedWord);

    }

    private boolean checkAns(String userWord){
        return answerWord.equals(userWord);
    }


    public StringBuilder toString(ArrayList<Character> list) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i< list.size()-1; i++){
            s.append(list.get(i));
            s.append(" ");

        }
        s.append(list.get(list.size()-1));
        return s;
    }

    GameApplication app = new GameApplication();

}