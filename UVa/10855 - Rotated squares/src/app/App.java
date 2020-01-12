package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (N == 0 && n == 0) {
                break;
            }

            char[][] big = new char[N][N];
            for (int i = 0; i < N; i++) {
                char[] row = reader.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    big[i][j] = row[j];
                }
            }

            char[][] small = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] row = reader.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    small[i][j] = row[j];
                }
            }

            System.out.print(count(big, small) + " ");
            small = rotate(small); // 90
            System.out.print(count(big, small) + " ");
            small = rotate(small); // 180
            System.out.print(count(big, small) + " ");
            small = rotate(small); // 270
            System.out.print(count(big, small) + "\n");
        }

        reader.close();
    }

    private static int count(char[][] big, char[][] small) {
        int count = 0;
        int sizeDifference = big.length - small.length;

        // Find first letter of small in big
        for (int i = 0; i <= sizeDifference; i++) {
            for (int j = 0; j <= sizeDifference; j++) {
                if (big[i][j] == small[0][0]) {
                    boolean isFound = true;

                    // Check if the entire square exists at this point
                    for (int k = 0; k < small.length; k++) {
                        for (int l = 0; l < small.length; l++) {
                            if (small[k][l] != big[i + k][j + l]) {
                                isFound = false;
                                break;
                            }
                        }
                    }

                    if (isFound) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static char[][] rotate(char[][] small) {
        int size = small.length;
        char[][] rotated = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[i][j] = small[size - j - 1][i];
            }
        }

        return rotated;
    }
}