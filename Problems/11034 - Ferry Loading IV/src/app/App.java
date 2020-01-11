package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();

        while (c-- > 0) {
            int l = scan.nextInt();
            int m = scan.nextInt();

            String currentBank = "left";
            double remainingCapacity = l;

            List<Double> leftCars = new ArrayList<>();
            List<Double> rightCars = new ArrayList<>();

            while (m-- > 0) {
                double carLength = scan.nextInt() / 100.0;
                String bank = scan.nextLine().trim();

                if (bank.equals("left")) {
                    leftCars.add(carLength);
                } else {
                    rightCars.add(carLength);
                }
            }

            int crosses = 0;
            while (!leftCars.isEmpty() || !rightCars.isEmpty()) {
                if (currentBank.equals("left")) {
                    loadFerry(leftCars, remainingCapacity);
                    currentBank = "right";
                } else {
                    loadFerry(rightCars, remainingCapacity);
                    currentBank = "left";
                }

                remainingCapacity = l;
                crosses++;
            }

            System.out.println(crosses);
        }

        scan.close();
    }

    private static void loadFerry(List<Double> load, double remainingCapacity) {
        Iterator<Double> it = load.iterator();
        while (it.hasNext()) {
            double carLength = it.next();
            if (carLength <= remainingCapacity) {
                remainingCapacity -= carLength;
                it.remove();
            } else {
                break;
            }
        }
    }
}