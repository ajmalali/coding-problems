package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        System.out.println("PERFECTION OUTPUT");

        int N;
        while ((N = scan.nextInt()) != 0) {

            int sum = 0;
            for (int i = 1; i <= N / 2; i++) {
                if ((N % i) == 0) {
                    sum += i;
                }
            }

            if (sum == N) {
                System.out.printf("%5d  PERFECT\n", N);
            } else if (sum < N) {
                System.out.printf("%5d  DEFICIENT\n", N);
            } else {
                System.out.printf("%5d  ABUNDANT\n", N);
            }
        }

        System.out.println("END OF OUTPUT");
        scan.close();
    }
}