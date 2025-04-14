package leetcodeDaily;

public class MinZeoArray {
    public static void main(String[] args) {
        int[] nums = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}};
        System.out.println(minZeroArray(nums, queries));
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        int low = 1, high = queries.length, res = -1;

        while (low <= high) {
            int mid  = low + (high - low) / 2;
            // Step 1: Initialize difference array
            int[] diff = new int[nums.length + 1];

            // Step 2: Apply first `mid` queries to difference array
            for (int i = 0; i < mid; i++) {
                int li = queries[i][0], ri = queries[i][1], val = queries[i][2];
                diff[li] -= val;
                diff[ri + 1] += val; // Undo effect after ri
            }
            // Step 3: Compute prefix sum and check if `nums` becomes zero
            int currReduction = 0;
            boolean isZeroArray = true;

            for (int i = 0; i < nums.length; i++) {
                currReduction += diff[i]; // Apply prefix sum effect
                if (nums[i] + currReduction > 0) { // Check if nums[i] is still > 0
                    isZeroArray = false;
                    break; // No need to check further
                }
            }
            if (isZeroArray) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
