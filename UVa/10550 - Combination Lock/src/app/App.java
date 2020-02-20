package app;

import java.io.FileInputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileInputStream("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            int c0 = scan.nextInt();
            int c1 = scan.nextInt();
            int c2 = scan.nextInt();
            int c3 = scan.nextInt();

            if (c0 + c1 + c2 + c3 == 0) {
                break;
            }

            int count = 120;

            if (c0 < c1) {
                count += 40 - (c1 - c0);
            } else {
                count += c0 - c1;
            }

            if (c1 < c2) {
                count += c2 - c1;
            } else {
                count += 40 - (c1 - c2);
            }

            if (c2 < c3) {
                count += 40 - (c3 - c2);
            } else {
                count += c2 - c3;
            }

            System.out.println(count * 9);
        }

        scan.close();
    }
}