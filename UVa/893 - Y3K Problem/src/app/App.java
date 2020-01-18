package app;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            int daysToPredict = scan.nextInt();
            if (daysToPredict == 0) {
                break;
            }

            int D = scan.nextInt();
            int M = scan.nextInt();
            int Y = scan.nextInt();

            // month is 0 based
            Calendar calendar = new GregorianCalendar(Y, M - 1, D);
            calendar.add(Calendar.DATE, daysToPredict);

            System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + " " + (calendar.get(Calendar.MONTH) + 1) + " "
                    + calendar.get(Calendar.YEAR));
        }

        scan.close();
    }
}