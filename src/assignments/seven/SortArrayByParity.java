package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/sort-array-by-parity/description/
//https://leetcode.com/problems/sort-array-by-parity-ii/description/
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int[] nums1 = {4,2,5,9,3,6};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
        System.out.println(Arrays.toString(sortArrayByParityII(nums1)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++)
            if (nums[j] % 2 == 0) {
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;
            }
        return nums;
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
