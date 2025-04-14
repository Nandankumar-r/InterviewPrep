package DSAMustSolve;

public class StairJump {
    // Memoization Array
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return climbStairs(n, dp);
    }

    public int climbStairs(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != 0) return dp[n];

        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }

    // Tabulation
    public int climbStairsTabulation(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;
        dp[n] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }

    // Tabulation - space optimized
    public int climbStairsOptimized(int n) {
        if (n <= 2) {
            return n;
        }
        int next = 1, next2 = 1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = next + next2;
            next2 = next;
            next = temp;
        }

        return next;
    }

}
