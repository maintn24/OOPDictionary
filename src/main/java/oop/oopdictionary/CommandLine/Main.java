package oop.oopdictionary.CommandLine;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DictionaryManagement dictionary = new DictionaryManagement();
        dictionary.insertFromFile("anhviet109K.txt");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; ; i++) {
            String text = sc.nextLine();
            dictionary.dictionaryLookUp(text);
        }
    }
}
