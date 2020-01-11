package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int caseNumber = 1;
        while (scan.hasNextInt()) {
            int R = scan.nextInt();
            int N = scan.nextInt();

            if (R == 0 && N == 0) {
                break;
            }

            if (R <= N) {
                System.out.println("Case " + caseNumber + ": 0");
                caseNumber++;
                continue;
            }

            boolean isPossible = false;
            for (int i = 1; i <= 26; i++) {
                int newNames = N * i;
                if (N + newNames >= R) {
                    isPossible = true;
                    System.out.println("Case " + caseNumber + ": " + i);
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case " + caseNumber + ": impossible");
            }

            caseNumber++;
        }

        scan.close();

    }
}