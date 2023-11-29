package oop.oopdictionary;//package Management;

import java.io.*;
import java.util.Dictionary;
import java.util.*;

public class DictionaryManagement {

    /** Add tu trong file. */
    public void insertFromFile(String pathFile) throws FileNotFoundException {
        //String pathFile = "data_Now.txt";
        Scanner scan = new Scanner(new File(pathFile));

        while (scan.hasNext()) {
            String target = scan.nextLine();
            String explain = scan.nextLine();

            oop.oopdictionary.Dictionary.hashMap.put(target, explain);
        }
    }


    /** Them tu vao trong tu dien. */
    public void addWord(String target, String explain) {
        oop.oopdictionary.Dictionary.hashMap.put(target, explain);
    }


    /**Xoa tu */
    public void removeWord(String target) {
        oop.oopdictionary.Dictionary.hashMap.remove(target);
    }


    /** thay thế từ. */
    public void modifyWord(String target, String explain) {
        oop.oopdictionary.Dictionary.hashMap.replace(target, explain);
    }

    /** tim tu */
    public String dictionaryLookUp (String target) {
         //return target + " : " + oop.oopdictionary.Dictionary.hashMap.get(target);
         return oop.oopdictionary.Dictionary.hashMap.get(target);
    }

    /** in tat ca tu khoa. */
    public String[] printAll() {
        Set<String> tapHopTuKhoa = oop.oopdictionary.Dictionary.hashMap.keySet();
        return tapHopTuKhoa.toArray(new String[0]);
    }


    /** in cac tu trong tu dien vao file */
    public void dictionaryExportToFile() throws IOException {
        FileOutputStream fout = new FileOutputStream("data_Now.txt");

        try (BufferedOutputStream bout = new BufferedOutputStream(fout)) {
            Set set =oop.oopdictionary.Dictionary.hashMap.entrySet();
            Iterator iterator = set.iterator();

            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                String line = mentry.getKey() + "\n" + mentry.getValue();
                bout.write(line.getBytes());
                bout.write(System.lineSeparator().getBytes());
            }
        }
    }

//    public static void main(String[] args){
//        DictionaryManagement dictionary = new DictionaryManagement();
//    }
}
