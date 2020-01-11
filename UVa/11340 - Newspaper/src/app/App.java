package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(reader.readLine());
        while (tests-- > 0) {
            int K = Integer.parseInt(reader.readLine());
            Map<Character, Double> table = new HashMap<>(K);

            while (K-- > 0) {
                String[] vals = reader.readLine().split(" ");
                table.put(vals[0].charAt(0), Integer.parseInt(vals[1]) / 100.0);
            }

            int M = Integer.parseInt(reader.readLine());
            double pay = 0;
            while (M-- > 0) {
                String line = reader.readLine();
                for (int i = 0; i < line.length(); i++) {
                    Double value = table.get(line.charAt(i));
                    if (value != null) {
                        pay += value;
                    }
                }
            }

            System.out.printf("%.2f$\n", pay);

        }
        reader.close();
    }
}