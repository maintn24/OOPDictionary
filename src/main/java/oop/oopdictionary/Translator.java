package oop.oopdictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Translator {
    static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbzeKpV171FTwUnJkYPFsmIRCQIzEnyQ8VuL-b4nGdu2KnZ5DffayFIDHR3QZ4onowvV2g/exec" +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }


    public static void main(String[] args) throws IOException {
//        /** gg dich. */
//        System.out.println("Type");
//        Scanner sc = new Scanner(System.in);
//        String text;
//        text = sc.nextLine();
//
//        System.out.println(translate("en", "vi", text));

        /** dich tu dien txt. */
        DictionaryManagement dictionary = new DictionaryManagement();
        dictionary.insertFromFile("data_Now.txt"); ///
        System.out.println("Import success");

        System.out.println(Arrays.toString(dictionary.printAll()));

        Scanner sc = new Scanner(System.in);
        String text;
        String lastWord = "none";
        String lastWordExplain = "none";
        do {
            System.out.print("Lookup: ");
            text = sc.nextLine();
            if (text.equals("add")) {
                System.out.print("nhap tu moi: ");
                String target = sc.nextLine();
                System.out.print("nhap nghia: ");
                String explain = sc.nextLine();
                dictionary.addWord(target, explain);
                System.out.println("Add success");
            } else if (text.equals("delete")){
                System.out.println("Are you sure you want to delete\n" + lastWord);
                if (Objects.equals(sc.nextLine(), "y")) {
                    dictionary.removeWord(lastWord);
                }
            }
            else {
                System.out.println(dictionary.dictionaryLookUp(text));
                lastWord = text;
            }
        } while (!text.equals("bb"));
    }
}