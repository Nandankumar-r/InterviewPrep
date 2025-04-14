package leetcodeDaily;

import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }
}
