package assignments.five;

import java.util.ArrayList;
import java.util.Arrays;

public class Shuffle {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for (int i = 0; i < n; i++) {
            res[2*i] = nums[i];
            res[2*i+1] = nums[i+n];
        }
        return res;
    }

    //In place Algorithm
    /*
    public void shuffle(int[] nums, int n) {
        // Encode the values in the array without using extra space
        for (int i = 0; i < 2 * n; i++) {
            int targetIndex = (i < n) ? 2 * i : 2 * (i - n) + 1;
            nums[targetIndex] |= (nums[i] % 1024) << 10;  // Store the old value in higher bits
        }

        // Decode the values to get the final shuffled array
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = nums[i] >> 10;  // Extract the new value
        }
    }
*/
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] res = shuffle(nums, n);
        System.out.println(Arrays.toString(res));
    }
}
