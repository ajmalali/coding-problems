package app;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));

        while (true) {
            String[] line = reader.readLine().split(" ");
            int S = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);

            if (S == 0 && B == 0) {
                break;
            }

            StringBuilder builder = new StringBuilder();
            int[] lefts = new int[S + 2];
            int[] rights = new int[S + 2];

            for (int i = 0; i <= S; i++) {
                lefts[i] = i - 1;
                rights[i] = i + 1;
            }

            while (B-- > 0) {
                line = reader.readLine().split(" ");
                int L = Integer.parseInt(line[0]);
                int R = Integer.parseInt(line[1]);

                if (lefts[L] == 0) {
                    builder.append("* ");
                } else {
                    builder.append(lefts[L] + " ");
                }

                if (rights[R] > S) {
                    builder.append("*\n");
                } else {
                    builder.append(rights[R] + "\n");
                }

                rights[lefts[L]] = rights[R];
                lefts[rights[R]] = lefts[L];
            }
            builder.append("-");
            System.out.println(builder.toString());
        }

        reader.close();
    }
}