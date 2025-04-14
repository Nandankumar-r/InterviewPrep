package DSAMustSolve;

import java.util.Arrays;

import static assignments.seven.FindErrorNums.swap;

public class MoveNegative {
    public static void main(String[] args) {
        int[] nums = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            while (nums[l] < 0) {
                l++;
            }
            swap(nums, l, h);
            h--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
