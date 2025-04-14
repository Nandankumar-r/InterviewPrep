package dpPatterns;

import java.util.Arrays;

public class Knapsack01 {
    static int[][] dp;
    public static void main(String[] args) {
        int[] weights = {3, 2, 4};
        int[] values = {6, 8, 7};
        int capacity = 5;
        dp = new int[weights.length + 1][capacity + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, - 1);
        }
        int res = knapsack01(weights, values, capacity, weights.length);
        System.out.println(res);
        int res1 = knapsack01BottomUp(weights, values, capacity, weights.length);
        System.out.println(res1);
    }

    //Without DP - O(2^N)
    //With DP - O(N * capacity).
    //Top down approach
    private static int knapsack01(int[] weights, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return dp[n][capacity] = 0;
        }

        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }
        if (weights[n - 1] > capacity) {
            return dp[n][capacity] = knapsack01(weights, values, capacity, n - 1);
        }

        return dp[n][capacity] = Math.max(knapsack01(weights, values, capacity, n - 1),
                values[n - 1] + knapsack01(weights, values, capacity - weights[n - 1], n - 1));
    }


    //Bottom up approach
    private static int knapsack01BottomUp(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];  // Exclude item
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        return dp[n][capacity];  // Max value we can obtain
    }
}
