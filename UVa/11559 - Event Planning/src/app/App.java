package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tests.txt"));

        while (scan.hasNextLine()) {
            int numParticipants = scan.nextInt();
            int budget = scan.nextInt();
            int numHotels = scan.nextInt();
            int numWeeks = scan.nextInt();

            int minBudget = Integer.MAX_VALUE;
            boolean hotelFound = false;

           for (int i = 0; i < numHotels; i++) {
                int stayTotal = scan.nextInt() * numParticipants;
                if (stayTotal > budget || stayTotal > minBudget) {
                    scan.nextLine();
                    scan.nextLine();
                    continue;
                }

                for (int j = 0; j < numWeeks; j++) {
                    int beds = scan.nextInt();
                    if (beds >= numParticipants) {
                        hotelFound = true;
                        if (stayTotal < minBudget) {
                            minBudget = stayTotal;
                        }
                        scan.nextLine();
                        break;
                    }
                }
            }

            System.out.println(hotelFound ? minBudget : "stay home");
        }

        scan.close();
    }
}