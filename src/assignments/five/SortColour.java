package assignments.five;

import java.util.Arrays;

public class SortColour {
    //0, 1, and 2 to represent the color red, white, and blue, respectively
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count_0++;
            } else if (nums[i] == 1) {
                count_1++;
            } else if (nums[i] == 2) {
                count_2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count_0 > 0) {
                nums[i] = 0;
                count_0--;

            }else if (count_1 > 0) {
                nums[i] = 1;
                count_1--;
            } else if (count_2 > 0) {
                nums[i] = 2;
                count_2--;
            }
        }
    }
}
