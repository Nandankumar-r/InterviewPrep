package assignments.ten;

import java.util.Arrays;

public class PerfectSquareCountDP {
    public static void main(String[] args) {
        PerfectSquareCountDP obj = new PerfectSquareCountDP();
        System.out.println(obj.numSquares(17));
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; //n + 1 because we add 0 as well. dp[0] = 0 is the base condition
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
