package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("tests.txt"));
        String bitString = "";
        int count = 0;

        while (scan.hasNextLine() && !(bitString = scan.nextLine()).equals("")) {
            count++;
            System.out.println("Case " + count + ":");
            int tests = scan.nextInt();

            while (tests-- > 0) {
                int i = scan.nextInt();
                int j = scan.nextInt();
                scan.nextLine();

                int startIndex = Math.min(i, j);
                int stopIndex = Math.max(i, j);
                
                String str = bitString.substring(startIndex, stopIndex+1);    
                boolean isSame = str.contains("0") && str.contains("1") ? false : true;
                System.out.println(isSame ? "Yes" : "No");
            }
        }
    }
}