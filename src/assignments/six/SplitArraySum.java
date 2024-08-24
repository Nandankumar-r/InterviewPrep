package assignments.six;

import java.util.Arrays;

public class SplitArraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }
    public static int splitArray(int[] nums, int k) {
        int start = 0, end = 0;
        for (int j : nums) {
            start = Math.max(start, j); // in the end of the loop this will contain the max item of the array
            end += j;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0, pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    //This cannot be added to the current sub array, add it to the new one so sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            //If we can split the array into more than k pieces (pieces > k) it means that the mid-value we picked is too small,
            // because we've already tried our best to make sure each part holds as many non-negative numbers as we can,
            // but we still have numbers left. So, it is impossible to cut the array into k parts and make sure each parts is no larger than mid.
            // We should increase k. This leads to start = mid + 1;
            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
