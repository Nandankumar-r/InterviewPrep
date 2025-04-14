package DSAMustSolve;

import java.util.Arrays;

public class MinCostStair {

    // Memoization
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(minCostClimbingStairs(cost, 0, dp), minCostClimbingStairs(cost, 1, dp));
    }

    public int minCostClimbingStairs(int[] cost, int i, int[] dp) {
        if (i >= cost.length) return 0;

        if (dp[i] != -1) return dp[i];

        return dp[i] = cost[i] + Math.min(minCostClimbingStairs(cost, i + 1, dp),
                minCostClimbingStairs(cost, i + 2, dp));
    }


    // Tabulation bottom up
    public int minCostClimbingStairsTabulation(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);

        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    // Tabulation optimized
    public int minCostClimbingStairsOptimized(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);

        int next = cost[n - 1], next2 = 0;
        for (int i = n - 2; i >= 0; i--) {
            int temp = cost[i] + Math.min(next, next2);
            next2 = next;
            next = temp;
        }
        return Math.min(next, next2);
    }
}
