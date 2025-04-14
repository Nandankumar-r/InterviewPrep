package DSAMustSolve;

import java.util.Arrays;

import static assignments.seven.FindErrorNums.swap;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no decreasing element is found, reverse the entire array
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 3: Find the next larger element from the right to swap with nums[index]
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
                break;
            }
        }

        // Step 4: Reverse the right part after index to get the next permutation
        reverse(nums, index + 1, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
