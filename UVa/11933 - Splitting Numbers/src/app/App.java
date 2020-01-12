package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int n = 0;
        while ((n = scan.nextInt()) != 0) {
            String binary = Integer.toBinaryString(n);

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            int count = 0;
            for (int i = binary.length() - 1; i >= 0; i--) {
                if (binary.charAt(i) == '1') {
                    if (count % 2 == 0) {
                        a.insert(0, "1");
                        b.insert(0, "0");
                    } else {
                        b.insert(0, "1");
                        a.insert(0, "0");
                    }
                    count++;
                } else {
                    a.insert(0, "0");
                    b.insert(0, "0");
                }
            }

            System.out.println(Integer.parseInt(a.toString(), 2) + " " + Integer.parseInt(b.toString(), 2));
        }

        scan.close();
    }
}