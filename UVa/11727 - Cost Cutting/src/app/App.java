package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("tests.txt"));
        int tests = scan.nextInt();
        
        int count = 0;
        while (tests-- > 0) {
            count++;
            int[] salaries = new int[3];
            for (int i = 0; i < salaries.length; i++) {
                salaries[i] = scan.nextInt();
            }

            Arrays.sort(salaries);
            System.out.println("Case " + count + ": " + salaries[1]);
        }
        scan.close();
    }
}