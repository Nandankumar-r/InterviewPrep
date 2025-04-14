package leetcodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DivisibleSubSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        while (index != -1){
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }


}
