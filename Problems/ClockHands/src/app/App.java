package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        // 30 degress per hour
        // 6 degress per minute

        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));
        while (true) {
            String[] time = reader.readLine().split(":");
            int H = Integer.parseInt(time[0]);
            int M = Integer.parseInt(time[1]);

            if (H == 0 && M == 0) {
                break;
            }

            double hourAngle = (H * 30) + (M / 60.0) * 30;
            double minuteAngle = M * 6;

            double angle = Math.abs(hourAngle - minuteAngle);

            System.out.printf("%.3f\n", angle >= 180 ? 360 - angle : angle);
        }

        reader.close();
    }
}