package app;

import java.io.FileInputStream;
import java.util.Scanner;

public class App {
    public static void main(final String[] args) throws Exception {
        final Scanner scan = new Scanner(new FileInputStream("tests.txt"));
        // final Scanner scan = new Scanner(System.in);

        while (scan.hasNextDouble()) {
            double Xm = scan.nextDouble();
            double Ym = scan.nextDouble();

            int N = scan.nextInt();

            Segment[] segments = new Segment[N];

            // ditance from point to station
            double minDistance = Double.MAX_VALUE;

            // station coordinates
            double Xs = 0;
            double Ys = 0;

            double x1 = scan.nextDouble();
            double y1 = scan.nextDouble();
            boolean isSolved = false;

            for (int i = 0, j = 0; i < (2 * N); i += 2, j++) {
                double x2 = scan.nextDouble();
                double y2 = scan.nextDouble();

                if (isSolved) {
                    continue;
                }

                double distance = -1;
                double tempx = -1;
                double tempy = -1;

                segments[j] = new Segment(x1, y1, x2, y2);

                if (isOnSegment(segments[j], Xm, Ym)) {
                    if (isActuallyOnSegment(segments[j], Xm, Ym)) {
                        Xs = Xm;
                        Ys = Ym;
                        isSolved = true;
                        continue;
                    }
                }

                // slope of a line perpendicular to y = mx + b is -1/m
                double m1 = calculateSlope(segments[j].x1, segments[j].y1, segments[j].x2, segments[j].y2);
                if (m1 == 0) {
                    distance = Math.abs(segments[j].y1 - Ym);
                    tempx = Xm;
                    tempy = segments[j].y1;

                } else {
                    double m2 = -1 / m1;

                    tempx = ((Ym - segments[j].y1) + (m1 * segments[j].x1 - m2 * Xm)) / (m1 - m2);
                    tempy = m2 * (tempx - Xm) + Ym;

                    if (isOnSegment(segments[j], tempx, tempy)) {
                        distance = getDistance(Xm, Ym, tempx, tempy);
                    } else {
                        double d1 = getDistance(segments[j].x1, segments[j].y1, Xm, Ym);
                        double d2 = getDistance(segments[j].x2, segments[j].y2, Xm, Ym);

                        if (d1 < d2) {
                            distance = d1;
                            tempx = segments[j].x1;
                            tempy = segments[j].y1;
                        } else {
                            distance = d2;
                            tempx = segments[j].x2;
                            tempy = segments[j].y2;
                        }
                    }

                }

                if (distance < minDistance) {
                    minDistance = distance;
                    Xs = tempx;
                    Ys = tempy;
                }

                x1 = x2;
                y1 = y2;
            }

            System.out.printf("%.4f\n%.4f\n", Xs, Ys);
        }

        scan.close();
    }

    private static double calculateSlope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    private static boolean isOnSegment(Segment segment, double x, double y) {
        double minX = Math.min(segment.x1, segment.x2);
        double maxX = Math.max(segment.x1, segment.x2);

        return x >= minX && x <= maxX;
    }

    private static boolean isActuallyOnSegment(Segment segment, double x, double y) {
        return getDistance(x, y, segment.x1, segment.y1) + getDistance(x, y, segment.x2, segment.y2) == getDistance(
                segment.x1, segment.y1, segment.x2, segment.y2);
    }

}

class Segment {
    double x1, x2;
    double y1, y2;

    public Segment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return x1 + " " + y1 + ", " + x2 + " " + y2;
    }
}