package oop.oopdictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryManagement {
    public void insertFromFile(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String englishWord = bufferedReader.readLine();
            englishWord = englishWord.replace("@", "");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Word word = new Word();
                word.setWordTarget(englishWord.trim());
                String meaning = line + "\n";
                while ((line = bufferedReader.readLine()) != null)
                    if (!line.startsWith("@")) meaning += line + "\n";
                    else {
                        englishWord = line.replace("@", "");
                        break;
                    }
                word.setWordExplain(meaning.trim());
                Dictionary.hashMap.put(word.getWordTarget(), word.getWordExplain());
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occur with file: " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
    }
    public void addWord(String target, String explain) {
        Dictionary.hashMap.put(target, explain);
    }


    /**Xoa tu */
    public void removeWord(String target) {
        Dictionary.hashMap.remove(target);
    }


    /** thay thế từ. */
    public void modifyWord(String target, String explain) {
        Dictionary.hashMap.replace(target, explain);
    }

    /** tim tu */
    public String dictionaryLookUp(String target) {
        if(Dictionary.hashMap.get(target) == null) {
            System.out.print("Từ này hiện chưa có");
        }
        else {
            System.out.println(target + " " + Dictionary.hashMap.get(target));
            return Dictionary.hashMap.get(target);
        }
        return "Từ này hiện chưa có";
    }
}