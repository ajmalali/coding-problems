package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));

        int tests = scan.nextInt();
        while (tests-- > 0) {
            long s = scan.nextInt();
            long d = scan.nextInt();

            if (s < d || (s + d) % 2 != 0) {
                System.out.println("impossible");
            } else {
                long score1 = (s + d) / 2;
                long score2 = s - score1;    
                System.out.println(score1 + " " + score2);
            }
        }

        scan.close();
    }
}