package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("tests.txt"));
        int tests = scan.nextInt();

        int count = 0;
        while (tests-- > 0) {
            count++;
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();

            int min = Math.min(Math.min(A, B), C);
            int max = Math.max(Math.max(A, B), C);

            if (A != min && A != max) {
                System.out.println("Case " + count + ": " + A);
            } else if (B != min && B != max) {
                System.out.println("Case " + count + ": " + B);
            } else {
                System.out.println("Case " + count + ": " + C);
            }
        }
    }
}