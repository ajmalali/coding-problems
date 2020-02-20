package app;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileInputStream("tests.txt"));
        // Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            String N = scan.next();

            int E = -1;
            boolean isFound = false;
            
            BigInteger two = BigInteger.TWO;
            for (E = 1; E <= 1073741824; E++) {
                String power = two.pow(E).toString();
                
                if ((power.length() > (2 * N.length())) && power.startsWith(N)) {
                    System.out.println(E);
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("no power of 2");
            }
        }

        scan.close();
    }
}