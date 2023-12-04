<<<<<<<< HEAD:src/main/java/oop/oopdictionary/dictclass/DictionaryManagement.java
package oop.oopdictionary.dictclass;//package Management;

import oop.oopdictionary.dictclass.Dictionary;
========
package oop.oopdictionary;//package Management;
>>>>>>>> ddc3eee9a5b117f043db46c049aa24a9b9734f0e:src/main/java/oop/oopdictionary/DictionaryManagement.java

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

<<<<<<<< HEAD:src/main/java/oop/oopdictionary/dictclass/DictionaryManagement.java
            oop.oopdictionary.dictclass.Dictionary.hashMap.put(target, explain);
========
            oop.oopdictionary.Dictionary.hashMap.put(target, explain);
>>>>>>>> ddc3eee9a5b117f043db46c049aa24a9b9734f0e:src/main/java/oop/oopdictionary/DictionaryManagement.java
        }
    }


    /** Them tu vao trong tu dien. */
    public void addWord(String target, String explain) {
<<<<<<<< HEAD:src/main/java/oop/oopdictionary/dictclass/DictionaryManagement.java
        oop.oopdictionary.dictclass.Dictionary.hashMap.put(target, explain);
========
        oop.oopdictionary.Dictionary.hashMap.put(target, explain);
>>>>>>>> ddc3eee9a5b117f043db46c049aa24a9b9734f0e:src/main/java/oop/oopdictionary/DictionaryManagement.java
    }


    /**Xoa tu */
    public void removeWord(String target) {
<<<<<<<< HEAD:src/main/java/oop/oopdictionary/dictclass/DictionaryManagement.java
        oop.oopdictionary.dictclass.Dictionary.hashMap.remove(target);
========
        oop.oopdictionary.Dictionary.hashMap.remove(target);
>>>>>>>> ddc3eee9a5b117f043db46c049aa24a9b9734f0e:src/main/java/oop/oopdictionary/DictionaryManagement.java
    }


    /** thay thế từ. */
    public void modifyWord(String target, String explain) {
        oop.oopdictionary.Dictionary.hashMap.replace(target, explain);
    }

    /** tim tu */
<<<<<<<< HEAD:src/main/java/oop/oopdictionary/dictclass/DictionaryManagement.java
    public void dictionaryLookUp(String target) {
         System.out.println(target + " : " + oop.oopdictionary.dictclass.Dictionary.hashMap.get(target));
    }

    /** in tat ca tu khoa. */
    public void printAll(){
        Set<String> tapHopTuKhoa = oop.oopdictionary.dictclass.Dictionary.hashMap.keySet();
        System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
========
    public String dictionaryLookUp (String target) {
         //return target + " : " + oop.oopdictionary.Dictionary.hashMap.get(target);
         return oop.oopdictionary.Dictionary.hashMap.get(target);
    }

    /** in tat ca tu khoa. */
    public String[] printAll() {
        Set<String> tapHopTuKhoa = oop.oopdictionary.Dictionary.hashMap.keySet();
        return tapHopTuKhoa.toArray(new String[0]);
>>>>>>>> ddc3eee9a5b117f043db46c049aa24a9b9734f0e:src/main/java/oop/oopdictionary/DictionaryManagement.java
    }


    /** in cac tu trong tu dien vao file */
    public void dictionaryExportToFile() throws IOException {
        FileOutputStream fout = new FileOutputStream("data_Now.txt");

        try (BufferedOutputStream bout = new BufferedOutputStream(fout)) {
<<<<<<<< HEAD:src/main/java/oop/oopdictionary/dictclass/DictionaryManagement.java
            Set set = oop.oopdictionary.dictclass.Dictionary.hashMap.entrySet();
========
            Set set =oop.oopdictionary.Dictionary.hashMap.entrySet();
>>>>>>>> ddc3eee9a5b117f043db46c049aa24a9b9734f0e:src/main/java/oop/oopdictionary/DictionaryManagement.java
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
