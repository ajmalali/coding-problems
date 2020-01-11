package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int tests = scan.nextInt();
        scan.nextLine();

        for (int i = 1; i <= tests; i++) {

            ArrayList<String> topPages = new ArrayList<>(10);
            int maxRelevance = Integer.MIN_VALUE;

            int c = 10;
            while (c-- > 0) {
                String URL = scan.next();
                int relevance = scan.nextInt();
                scan.nextLine();

                if (relevance == maxRelevance) {
                    topPages.add(URL);
                } else if (relevance > maxRelevance) {
                    maxRelevance = relevance;
                    topPages.removeAll(topPages);
                    topPages.add(URL);
                }
            }

            System.out.println("Case #" + i + ":");
            for (String page : topPages) {
                System.out.println(page);
            }

        }

        scan.close();
    }
}