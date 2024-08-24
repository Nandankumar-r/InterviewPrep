package assignments.six;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,2,3,4,5,5,5,5,6,7,8,8,8,8,8,9};
        int[] res = searchRange(nums, 5);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = search(nums, target, true);
        result[1] = search(nums, target, false);
        return result;
    }

    private static int search (int[] nums, int target, boolean isFirstSearch) {
        int start = 0, end = nums.length - 1, idx = -1;

        while (start <= end) {
            int mid  = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
            if (target == nums[mid]) {
                idx = mid;
                if (isFirstSearch) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return idx;
    }
}
