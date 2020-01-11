package app;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int[] sequence = new int[n];

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = scan.nextInt();
                set.add(i+1);
            }
            set.remove(n);

            int difference = 0;
            for (int i = 0; i < sequence.length - 1; i++) {
                difference = Math.abs(sequence[i] - sequence[i + 1]);
                set.remove(difference);
            }

            System.out.println(set.size() == 0 ? "Jolly" : "Not jolly");
        }

        scan.close();
    }
}