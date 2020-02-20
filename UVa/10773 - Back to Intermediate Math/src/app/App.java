package app;

import java.io.FileInputStream;
import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileInputStream("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        int tests = scan.nextInt();
        for (int i = 1; i <= tests; i++) {
            System.out.print("Case "  + i + ": ");

            double d = scan.nextDouble();
            double v = scan.nextDouble();
            double u = scan.nextDouble();

            if (u <= v || u == 0 || v == 0) {
                System.out.println("can't determine");
            } else {
                double t1 = d/(Math.sin(Math.acos(v/u))*u);
                double t2 = (d / u);

                System.out.printf("%.3f\n", Math.abs(t1 - t2));
            }
        }

        scan.close();
    }
}