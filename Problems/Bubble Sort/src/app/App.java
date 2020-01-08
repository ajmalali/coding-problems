package app;

import java.io.File;
import java.util.Scanner;

public class App {

    /*
     * Solution explanation:
     * http://openology.blogspot.com/2013/08/how-i-solved-uva-12004-bubble-sort.html
     */

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        int tests = scan.nextInt();

       for (int i = 0; i < tests; i++) {
            long n = scan.nextInt();
            long maxSwaps = n * (n - 1) / 2;
            
            System.out.print("Case " + (i+1) + ": ");
            System.out.println(maxSwaps % 2 == 0 ? maxSwaps / 2 : maxSwaps + "/2");
        }

        scan.close();
    }
}