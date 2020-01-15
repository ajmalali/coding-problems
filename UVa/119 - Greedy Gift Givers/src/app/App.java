package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        
        while (scan.hasNextLine()) {
            int N = scan.nextInt();
            ArrayList<String> names = new ArrayList<>();
            int[] amounts = new int[N];
            
            for (int i = 0; i < N; i++) {
                names.add(scan.next());
            }
        
            while (N-- > 0) {
                String giver = scan.next();
                int totalAmount = scan.nextInt();
                int numFriends = scan.nextInt();

                int giverIndex = names.indexOf(giver);

                if (numFriends == 0) {
                    continue;
                }
                
                int giftAmount = totalAmount/numFriends;
                amounts[giverIndex] -= numFriends*giftAmount;

                while (numFriends-- > 0) {
                    String receiver = scan.next();
                    int receiverIndex = names.indexOf(receiver);
                    amounts[receiverIndex] += giftAmount;
                }
            }
            scan.nextLine();

            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i) + " " + amounts[i]);
            }
            System.out.println();
        }
    }
}