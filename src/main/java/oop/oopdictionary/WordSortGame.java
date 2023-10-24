package oop.oopdictionary;

import java.util.*;

public class WordSortGame {
    List<String> wordDone = new ArrayList<>();
    List<String> wordList = new ArrayList<String>();

    int score = 0;


    private void generateWordList() {
        wordList.add("hello");
        wordList.add("banana");
        wordList.add("orange");
        wordList.add("apple");
    }
    private String randomWord(List<String> wordList, List<String> wordDone) {
        int randIndex = (int) (Math.random() * wordList.size());
        String word = wordList.get(randIndex);
        wordDone.add(word);
        wordList.remove(word);
        //System.out.println(word);
        //System.out.println("There are " + wordList.toString());
        wordDone.add(word);
        return word;
    }

     private void generateLetters(String word){
        ArrayList<Character> unsortedWord = new ArrayList<Character>();
        for(int i = 0; i< word.length(); i++){
            Character c = word.charAt(i);
            unsortedWord.add(c);
        }
        Collections.shuffle(unsortedWord);

        System.out.println(unsortedWord);
    }

    private boolean checkAns(String word, String userWord){
        return word.equals(userWord);
    }

    private void showScore() {
        System.out.println("Congratulation!! Your score is: " + score);
    }

    private void gameLoop() {
        int totalOfQuestion = wordList.size();
        int tmpIndex = totalOfQuestion;
        int currentQuestion = 1;
        while (tmpIndex > 0) {
            System.out.println("------------Question: " + currentQuestion + "/" + totalOfQuestion + " -----------------");

            String word = randomWord(wordList,wordDone);
            generateLetters(word);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the correct word: ");
            String userWord = sc.nextLine();

            System.out.println("Your input is " + userWord);
            if(checkAns(word, userWord)) {
                score += 10;
                System.out.println("Correct");
            } else System.out.println("Wrong");
            currentQuestion++;
            tmpIndex--;
        }
        showScore();
    }

    public static void main(String[] args){
        WordSortGame game = new WordSortGame();
        game.generateWordList();
        game.gameLoop();
    }
}
