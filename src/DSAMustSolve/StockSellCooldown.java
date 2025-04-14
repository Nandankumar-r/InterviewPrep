package DSAMustSolve;

public class StockSellCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        dp[n][0] = dp[n][1] = 0;
        dp[n + 1][0] = dp[n + 1][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                // compute dp[i][canBuy] using dp[i+1] and dp[i+2]
                if (canBuy == 1) {
                    dp[i][1] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    dp[i][0] = Math.max(prices[i] + dp[i+2][1], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
