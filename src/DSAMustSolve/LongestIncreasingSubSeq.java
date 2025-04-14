package DSAMustSolve;

import java.util.Arrays;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // every element can be a subsequence of length 1
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
