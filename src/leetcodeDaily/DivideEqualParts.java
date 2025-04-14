package leetcodeDaily;

import java.util.HashSet;

public class DivideEqualParts {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,2,2,4,4};
        System.out.println(divideArray(nums));
    }

    public static boolean divideArray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);
            }
        }
        return set.isEmpty();
    }
}
