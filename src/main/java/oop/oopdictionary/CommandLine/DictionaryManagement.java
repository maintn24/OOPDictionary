package oop.oopdictionary.CommandLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Set;

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
                Dictionary1.hashMap.put(word.getWordTarget(), word.getWordExplain());
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occur with file: " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
    }
    public void addWord(String target, String explain) {
        Dictionary1.hashMap.put(target, explain);
    }


    /**Xoa tu */
    public void removeWord(String target) {
        Dictionary1.hashMap.remove(target);
    }


    /** thay thế từ. */
    public void modifyWord(String target, String explain) {
        Dictionary1.hashMap.replace(target, explain);
    }

    /** tim tu */
    public void dictionaryLookUp(String target) {
        if(Dictionary1.hashMap.get(target) == null) {
            System.out.print("Từ này hiện chưa có");
        }
        else {
            System.out.println(target + " " + Dictionary1.hashMap.get(target));
        }
    }

    /** in tat ca tu khoa. */
    public void printAll(){
        Set<String> tapHopTuKhoa = Dictionary1.hashMap.keySet();
        System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
    }
}


