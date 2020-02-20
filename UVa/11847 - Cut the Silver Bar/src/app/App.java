package app;

import java.io.FileInputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileInputStream("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int N = -1;
        while ((N = scan.nextInt()) != 0) {
            int cuts = (int) Math.floor(Math.log(N)/Math.log(2));
            System.out.println(cuts);
        }

        scan.close();
    }
}