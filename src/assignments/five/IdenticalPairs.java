package assignments.five;

import java.util.HashMap;
import java.util.List;

public class IdenticalPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int res = numIdenticalPairs(nums);
        System.out.println(res);
    }

    public static int numIdenticalPairs(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            res += count;
            map.put(num, count+1);
        }
        return res;
    }
}
