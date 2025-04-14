package DSAMustSolve;

public class NoOfUniquePaths {
    public static void main(String[] args) {
        NoOfUniquePaths obj = new NoOfUniquePaths();
        System.out.println(obj.uniquePathsTabulation(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePaths(m, n, m - 1, n - 1, dp);
    }

    public int uniquePaths(int m, int n, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 1;

        if (dp[i][j] != 0) return dp[i][j];

        dp[i][j] = uniquePaths(m, n, i - 1, j, dp) + uniquePaths(m, n, i, j - 1, dp);
        return dp[i][j];
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill first row and first column with 1s
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsOptimized(int m, int n) {
        // Initialize a 1D array to store the number of ways to reach each cell in the current row
        int[] previousRow = new int[n];

        for (int row = 0; row < m; row++) {
            // Create a new array for the current row
            int[] currentRow = new int[n];

            for (int col = 0; col < n; col++) {
                // Base case: the starting cell (0,0) has exactly 1 way to reach
                if (row == 0 && col == 0) {
                    currentRow[col] = 1;
                } else {
                    // If not in the first row, you can come from the cell above
                    int fromAbove =  row > 0 ? previousRow[col] : 0;
                    // If not in the first column, you can come from the cell to the left
                    int fromLeft = col > 0 ? currentRow[col - 1] : 0;

                    // Total ways to reach current cell = from above + from left
                    currentRow[col] = fromAbove + fromLeft;
                }
            }

            // Update previousRow to currentRow for the next iteration
            previousRow = currentRow;
        }

        // The bottom-right corner value is the answer
        return previousRow[n - 1];
    }

}
