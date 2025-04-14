package assignments.slidingWindow;

//Given an array and an integer k, find the maximum sum of any contiguous subarray of size k
public class MaxSumSubArray {
    public static void main(String[] args) {
        /*int[] nums = {3};
        int k = 1;
        int res;
        int currentSum = 0;

        if (k > nums.length) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        res = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            res = Math.max(res, currentSum);
        }*/
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = findSubArraySize(nums, 7);
        System.out.println(res);
    }

    //Find the smallest subarray with a sum ≥ target in a given array of positive integers.
    // If no such subarray exists, return 0
    private static int findSubArraySize(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int l = 0, currentSum = 0;

        for (int r = 0; r < nums.length; r++) {
            currentSum += nums[r];
            while (currentSum >= target) {
                res = Math.min(res, r - l + 1);
                currentSum -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
