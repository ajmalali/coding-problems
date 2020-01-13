package app;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int tests = scan.nextInt();
        while (tests-- > 0) {
            int totalPoints = scan.nextInt();

            Point[] points = new Point[totalPoints];
            for (int i = 0; i < totalPoints; i++) {
                points[i] = new Point(scan.nextInt(), scan.nextInt());
            }

            Arrays.sort(points);

            double totalLength = 0;
            Point currentPeak = new Point();

            for (int i = points.length - 1; i >= 0; i--) {
                if (points[i].y > currentPeak.y) {
                    Point heightPoint = new Point(points[i].x, points[i + 1].y);
                    double bigHeight = points[i].y - heightPoint.y;
                    double bigBase = points[i + 1].x - heightPoint.x;
                    double angle = Math.atan(bigHeight / bigBase);
                    double smallHeight = points[i].y - currentPeak.y;
                    double hypotenuse = smallHeight / Math.sin(angle);
                    totalLength += hypotenuse;

                    currentPeak = points[i];
                }
            }

            System.out.printf("%.2f\n", totalLength);

        }

        scan.close();
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point c) {
        return this.x - c.x;
    }

}