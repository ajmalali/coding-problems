package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(LIS(new int[] { 1, 3, 2, 4, 3 })); // 3
        System.out.println(LIS(new int[] { 2, 7, 4, 3, 8 })); // 3
        System.out.println(LIS(new int[] { 5, 4, 3, 2, 1 })); // 1
        System.out.println(LIS(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })); // 9
    }

    private static int LIS(int[] A) {

        int n = A.length;

        // Holds the final LIS value
        int max = Integer.MIN_VALUE;

        // Holds max LIS till each position
        int[] M = new int[n];
        Arrays.fill(M, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (A[j] < A[i]) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }

            if (M[i] > max) {
                max = M[i];
            }
        }

        return max;
    }
}