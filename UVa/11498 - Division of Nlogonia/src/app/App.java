package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("tests.txt"));

        int K = 0;

        while ((K = scan.nextInt()) != 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();

            while (K-- > 0) {
                int X = scan.nextInt();
                int Y = scan.nextInt();

                int xDiff = X - N;
                int yDiff = Y - M;

                if (xDiff == 0 || yDiff == 0) {
                    System.out.println("divisa");
                } else if (xDiff > 0) {
                    if (yDiff > 0) {
                        System.out.println("NE");
                    } else {
                        System.out.println("SE");
                    }
                } else {
                    if (yDiff > 0) {
                        System.out.println("NO");
                    } else {
                        System.out.println("SO");
                    }
                }
            }
        }
        scan.close();
    }
}