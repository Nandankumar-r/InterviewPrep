package DSAMustSolve;

import java.util.Arrays;

import static assignments.seven.FindErrorNums.swap;

public class Sort012 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 1, 2};
        int l = 0, m = 0, h = nums.length - 1;
        while (m <= h) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, h);
                h--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
