package DSAMustSolve;

import java.util.HashSet;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] a = {85, 25, 1, 32, 54, 6}, b = {85, 2};
        HashSet<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }
        System.out.println(set.size());
    }

    public static class HouseRobbery {
        // Houses are linear
        public int robLinear(int[] nums) {
            int rob1 = 0, rob2 = 0;
            for (int num : nums) {
                int temp = Math.max(num + rob1, rob2);
                rob1 = rob2;
                rob2 = temp;
            }
            return rob2;
        }

        // Houses are in circle so 1st and last house are neighbours

        public int robCircular(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];

            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }

        public int rob(int[] nums, int start, int end) {
            int rob1 = 0, rob2 = 0;
            for (int i = start; i <= end; i++) {
                int temp = Math.max(nums[i] + rob1, rob2);
                rob1 = rob2;
                rob2 = temp;
            }
            return rob2;
        }
    }
}
