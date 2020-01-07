package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);        
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            System.out.println(v * t * 2);
        }
        
        reader.close();
    }
}