package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String line = null;
        while (!(line = reader.readLine()).equals("Game Over")) {
            st = new StringTokenizer(line);
            int sum = 0;
            
            while (st.hasMoreTokens()) {
                String score = st.nextToken();
                
                if (score.equals("X")) {

                } else if (score.equals("/")) {

                } else {
                    sum += Integer.parseInt(score);
                }
            }

            System.out.println(sum);
        }

        reader.close();
    }
}