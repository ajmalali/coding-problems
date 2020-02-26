package app;

public class App {
    public static void main(String[] args) throws Exception {
        String A = "AXBCY";
        String B = "ZAYWBC";
        System.out.println(LCS(A, B)); // ABC

        A = "398397970";
        B = "3399917206";
        System.out.println(LCS(A, B)); // 339970
    }

    // Calculates the LCS and backtracks to return the string
    private static String LCS(String A, String B) {

        int rows = A.length();
        int cols = B.length();

        // Create the memoization table with an extra row and column
        // (It is initalized to 0 by default)
        int[][] M = new int[rows + 1][cols + 1];

        // Start from index 1
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // If there's a match, add 1 to the previous diagonal
                    // element and store in current position

                    M[i][j] = 1 + M[i - 1][j - 1];
                } else {
                    // Else take the max of the previous column and the previous row
                    // and store in current position

                    M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                }
            }
        }

        int LCSLength = M[rows][cols];

        if (LCSLength == 0) {
            System.out.println("No commong string");
            return "";
        }

        // To find the LCS string, we backtrack from the bottom of M table
        StringBuilder LCS = new StringBuilder();
        int i = rows;
        int j = cols;

        while (i > 0 && j > 0) {

            // The place of a match
            if (M[i][j] > M[i - 1][j] && M[i][j] > M[i][j - 1]) {
                
                // Add to the front of the string
                LCS.insert(0, A.charAt(i - 1));
                
                // Go back diagoanlly
                i--;
                j--;
            } else if (M[i - 1][j] > M[i][j - 1]) {
                // Go back one row
                i--;
            } else {
                // Go back one column
                j--;
            }
        }

        return LCS.toString();
    }
}