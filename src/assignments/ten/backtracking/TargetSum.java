package assignments.ten.backtracking;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    /*
    Input: nums = [1,1,1,1,1], target = 3
    Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3
     */
    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(targetSum.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        // Use a memoization map where the key is "index,currentSum"
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, target, 0, 0, memo);
    }

    private int helper(int[] nums, int target, int index, int sum, Map<String, Integer> memo) {
        if (index == nums.length) {
            return (sum == target) ? 1 : 0;
        }

        String key = index + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = helper(nums, target, index + 1, sum + nums[index], memo);
        int subtract = helper(nums, target, index + 1, sum - nums[index], memo);

        int ways = add + subtract;
        memo.put(key, ways);
        return ways;
    }
}
