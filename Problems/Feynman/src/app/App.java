package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int N = 0;
        while ((N = scan.nextInt()) != 0) {
            int squares = (N * (N + 1) * ((2 * N) + 1)) / 6;
            System.out.println(squares);
        }

        scan.close();
    }
}