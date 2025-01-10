package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-1, 2, -3, 4, -9};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int resIndex = nums.length - 1;

        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                res[resIndex--] = nums[start] * nums[start];
                start++;
            } else {
                res[resIndex--] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}
