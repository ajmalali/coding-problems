package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));

        StringTokenizer st = new StringTokenizer("");
        String[] currentTime = new String[3];
        double startingTime = 0;

        int speed = 0;
        double distance = 0;
        double totalDistance = 0;
        double difference = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            st = new StringTokenizer(line);
            String timeString = st.nextToken();
            currentTime = timeString.trim().split(":");
            // Convert to hours
            double newTime = Integer.parseInt(currentTime[0]) + (Integer.parseInt(currentTime[1]) / 60.0)
                    + (Integer.parseInt(currentTime[2]) / 3600.0);

            difference = newTime - startingTime;
            distance = speed * difference;

            if (st.hasMoreTokens()) {
                speed = Integer.parseInt(st.nextToken());
                startingTime = newTime;
                totalDistance += distance;
            } else {
                System.out.printf("%s %.2f km\n", timeString, totalDistance + distance);
            }
        }

        reader.close();
    }
}