package dpPatterns;

import java.util.Arrays;

public class SubSetSumProblems {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10};
        int target = 11;
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(findTargetSumSubArray(nums, target));

        System.out.println(findTargetSumSubArrayTopDown(nums, target, n, dp));
    }

    //Bottom up (Tabulation)
    //O(N*Target)
    private static boolean findTargetSumSubArray(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case: sum=0 is always achievable (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];  // Exclude current element
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];  // Include or exclude
                }
            }
        }

        return dp[n][target];
    }

    //Top down (Memoization)
    //O(N*Target)
    private static boolean findTargetSumSubArrayTopDown(int[] nums, int target, int n, int[][] dp) {
        if (target == 0) return true;
        if (n == 0) return false;

        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }

        // If the current element is greater than target, exclude it
        if (nums[n - 1] > target) {
            dp[n][target] = findTargetSumSubArrayTopDown(nums, target, n - 1, dp) ? 1 : 0;
        } else {
            // Either exclude or include the current element
            dp[n][target] = (findTargetSumSubArrayTopDown(nums, target, n - 1, dp) ||
                    findTargetSumSubArrayTopDown(nums, target - nums[n - 1], n - 1, dp)) ? 1 : 0;
        }
        return dp[n][target] == 1;
        }
    }
