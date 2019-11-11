package app;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        HashMap<String, String> reverses = initMap();

        while (scan.hasNextLine()) {
            String orignal = scan.next();
            scan.nextLine();
            StringBuilder mirriored = new StringBuilder();
            boolean meetsAllCriterias = true;

            for (int i = 0; i < orignal.length(); i++) {
                char c = orignal.charAt(i);

                String reverse = reverses.get(c + "");
                if (reverse != null) {
                    mirriored.append(reverse);
                } else {
                    meetsAllCriterias = false;
                    mirriored.append(c + "");
                }
            }

            if (isMirror(mirriored.toString(), orignal) && meetsAllCriterias) {
                if (isPalindrome(mirriored.toString())) {
                    System.out.println(orignal + " -- is a mirrored palindrome.\n");
                } else {
                    System.out.println(orignal + " -- is a mirrored string.\n");
                }
            } else {
                if (isPalindrome(mirriored.toString())) {
                    System.out.println(orignal + " -- is a regular palindrome.\n");
                } else {
                    System.out.println(orignal + " -- is not a palindrome.\n");
                }
            }
        }
    }

    private static boolean isPalindrome(String test) {
        StringBuilder temp = new StringBuilder(test);
        return test.equals(temp.reverse().toString());
    }

    private static boolean isMirror(String test, String orignal) {
        StringBuilder temp = new StringBuilder(test);
        return orignal.equals(temp.reverse().toString());
    }

    private static HashMap<String, String> initMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("E", "3");
        map.put("H", "H");
        map.put("I", "I");
        map.put("J", "L");
        map.put("L", "J");
        map.put("M", "M");
        map.put("O", "O");
        map.put("S", "2");
        map.put("T", "T");
        map.put("U", "U");
        map.put("V", "V");
        map.put("W", "W");
        map.put("X", "X");
        map.put("Y", "Y");
        map.put("Z", "5");
        map.put("1", "1");
        map.put("2", "S");
        map.put("3", "E");
        map.put("5", "Z");
        map.put("8", "8");
        return map;
    }
}