package assignments.five;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int [] {i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
