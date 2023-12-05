package oop.oopdictionary;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import oop.oopdictionary.wordsortgame.WordSortGame;
import oop.oopdictionary.quizgame.WordQuizGame;

public class MainCMD {
    public static void main(String[] args) {
        DictionaryManagement dictionary = new DictionaryManagement();
        dictionary.insertFromFile("data.txt");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {

            System.out.println("------------");
            System.out.println("MENU");
            System.out.println("Welcome to my dictionary \n"+"1. Add word\n"+"2. Delete word \n"+"3. Lookup \n"+"4. Modify word \n" + "5. Game Word Sorting \n" + "6. Game Quizz \n" + "0.Exit \n");


            option=sc.nextInt(); sc.nextLine();

            if(option == 1) {
                System.out.println("Enter the word: ");
                String tuKhoa = sc.nextLine();
                System.out.println("Enter explain: ");
                String yNghia = sc.nextLine();
                dictionary.addWord(tuKhoa, yNghia);
            }else if(option == 2 || option == 3) {
                System.out.println("Enter the word: ");
                String tuKhoa = sc.nextLine();
                if(option == 2){
                    dictionary.removeWord(tuKhoa);
                }else {
                    System.out.println(dictionary.dictionaryLookUp(tuKhoa));
                }
            } else if (option == 4) {
                System.out.println("Enter the word to be corrected: ");
                String tuKhoa = sc.nextLine();
                System.out.println("7.Edit from the original \n" + "8.Edit meaning \n");
                int tmpOption = 0;
                tmpOption = sc.nextInt();
                sc.nextLine();
                if(tmpOption == 8) {
                    dictionary.removeWord(tuKhoa);
                    System.out.println("Re-enter the keyword: ");
                    String newWord = sc.nextLine();
                    System.out.println("Re-enter the meaning: ");
                    String newExplanation = sc.nextLine();
                    dictionary.addWord(newWord, newExplanation);
                } else {
                    System.out.println("Enter the correct meaning: ");
                    String YNghiaMoi = sc.nextLine();
                    dictionary.addWord(tuKhoa,YNghiaMoi);
                }
            } else if (option == 5) {
                WordSortGame sortGame = new WordSortGame();
                sortGame.start();
            } else if (option == 6){
                WordQuizGame quizGame = new WordQuizGame();
                quizGame.start();
            }
        }while(option != 0);
    }
}