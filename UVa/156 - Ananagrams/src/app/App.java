package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        Map<String, String> map = new HashMap<>();
        String word = "";

        while (scan.hasNext() && !(word = scan.next()).equals("#")) {
            char[] normalized = word.toLowerCase().toCharArray();
            Arrays.sort(normalized);
            String key = String.valueOf(normalized);

            if (map.containsKey(key)) {
                map.put(key, "");
            } else {
                map.put(key, word);
            }
        }

        ArrayList<String> ananagrams = new ArrayList<>();
        for (String s : map.values()) {
            if (!s.isEmpty()) {
                ananagrams.add(s);
            }
        }

        Collections.sort(ananagrams);

        for (String w : ananagrams) {
            System.out.println(w);
        }

        scan.close();
    }
}