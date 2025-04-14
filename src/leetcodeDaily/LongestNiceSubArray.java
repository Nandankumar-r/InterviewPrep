package leetcodeDaily;

public class LongestNiceSubArray {
    public static void main(String[] args) {
    int[] nums = {1,3,8,48,10};
        System.out.println(longestNiceSubarray(nums));
    }

    public static int longestNiceSubarray(int[] nums) {
        int res = 0;
        int l = 0; // Left pointer of the sliding window
        int cur = 0; // Bitmask to track the OR result of the current subarray

        for (int r = 0; r < nums.length; r++) { // Iterate through the array using the right pointer
            // If the current number has overlapping bits with the existing subarray,
            // shrink the window from the left
            while ((cur & nums[r]) != 0) {
                cur ^= nums[l]; // Remove nums[l] from the bitmask
                l++; // Move left pointer forward
            }

            // Update the maximum length of the nice subarray
            res = Math.max(res, r - l + 1);

            // Include the current number in the bitmask
            cur |= nums[r];
        }

        return res;
    }
}
