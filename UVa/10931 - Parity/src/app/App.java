package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("tests.txt"));

        int I;
        while ((I = scan.nextInt()) != 0) {
            String B = Integer.toBinaryString(I);
            int parity = Integer.bitCount(I);
            System.out.println("The parity of " + B + " is " + parity + " (mod 2).");
        }
        scan.close();
    }
}