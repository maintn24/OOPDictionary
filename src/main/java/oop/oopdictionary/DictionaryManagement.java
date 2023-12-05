package oop.oopdictionary;

import java.io.*;
import java.util.*;

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
            //System.out.println(target + " " + Dictionary.hashMap.get(target));
            return Dictionary.hashMap.get(target);
        }
        return "Từ này hiện chưa có";
    }

    /** in cac tu trong tu dien vao file */
    public void dictionaryExportToFile() throws IOException {
        FileOutputStream fout = new FileOutputStream("data_Now.txt");

        try (BufferedOutputStream bout = new BufferedOutputStream(fout)) {
            Set set = Dictionary.hashMap.entrySet();
            Iterator iterator = set.iterator();

            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                String line = mentry.getKey() + "\n" + mentry.getValue();
                bout.write(line.getBytes());
                bout.write(System.lineSeparator().getBytes());
            }
        }
    }

    /** in tat ca tu khoa. */
    public void printAll(){
        Set<String> tapHopTuKhoa = oop.oopdictionary.Dictionary.hashMap.keySet();
        System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
    }

    public static void main(String[] args) throws IOException {
        DictionaryManagement dictionary = new DictionaryManagement();
        dictionary.insertFromFile("data"); ///
        System.out.println("Import success");

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
            } else if (text.equals("export")) {
                dictionary.dictionaryExportToFile();
                System.out.println("File exported");
            }
            else {
                System.out.println(dictionary.dictionaryLookUp(text));
                lastWord = text;
            }
        } while (!text.equals("bb"));
    }
}