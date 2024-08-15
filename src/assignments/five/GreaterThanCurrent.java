package assignments.five;

import java.util.ArrayList;
import java.util.Arrays;

public class GreaterThanCurrent {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int[] res = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(res));

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp++;
                }
            }
            res[i] = temp;
        }
        return res;
    }
}
