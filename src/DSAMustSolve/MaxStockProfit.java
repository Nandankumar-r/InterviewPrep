package DSAMustSolve;

public class MaxStockProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low)
                low = prices[i];
            int profitOnDay = prices[i] - low;
            if (profitOnDay > profit)
                profit = profitOnDay;
        }
        return profit;
    }

    public static int maxProfitMultiple(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
