//package Management;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DictionaryManagement {

    /** Them tu tu trong file. */
    public void insertFromFile(String pathFile) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(pathFile));

        while (scan.hasNext()) {
            String target = scan.nextLine();
            String explain = scan.nextLine();

            Dictionary.hashMap.put(target, explain);
        }
    }


    /** Them tu vao trong tu dien. */
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
    public void dictionaryLookUp(String target) {
         System.out.println(target + " : " + Dictionary.hashMap.get(target));
    }

    /** in tat ca tu khoa. */
    public void printAll(){
        Set<String> tapHopTuKhoa = Dictionary.hashMap.keySet();
        System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
    }


    /** in cac tu trong tu dien vao file */
    public void dictionaryExportToFile() throws FileNotFoundException, IOException {
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
}
