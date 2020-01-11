package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            int total = n;
            while (n >= k) {
                total += (n / k);
                n = (n / k) + (n % k);
            }

            System.out.println(total);
        }

        scan.close();
    }
}