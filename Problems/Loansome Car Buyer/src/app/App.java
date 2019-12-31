package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("tests.txt"));
        int duration = 0;

        while ((duration = scan.nextInt()) > 0) {
            double downPayment = scan.nextDouble();
            double loanAmount = scan.nextDouble();
            double monthlyPayment = loanAmount/duration;
            double carValue = loanAmount + downPayment;
            int n = scan.nextInt();
            double[] depreciations = getDepreciationRecords(scan, n, duration);
            
            carValue = carValue * (1-depreciations[0]);
            int month = 0;
            while (loanAmount > carValue) {
                month++;
                carValue = carValue * (1-depreciations[month]);
                loanAmount -= monthlyPayment;
            }

            System.out.println(month == 1?  "1 month" : month + " months");
        }
    }

    private static double[] getDepreciationRecords(Scanner scan, int n, int duration) {
        double[] depRecords = new double[duration+1];
        while (n-- > 0) {
            int month = scan.nextInt();
            double percentage = scan.nextDouble();
            for (int i = month; i < depRecords.length; i++) {
                depRecords[i] = percentage;
            }
        }
        return depRecords;
    }
}