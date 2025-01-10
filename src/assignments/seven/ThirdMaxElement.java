package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/third-maximum-number/
public class ThirdMaxElement {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        // Variables to track the top three distinct maximums
        Integer first = null, second = null, third = null;

        for (int num : nums) {
            Integer number = num;
            // Skip duplicates
            if (number.equals(first) || number.equals(second) || number.equals(third)) {
                continue;
            }

            if (first == null || number > first) {
                // Shift downwards
                third = second;
                second = first;
                first = number;
            } else if (second == null || number > second) {
                // Shift second and third
                third = second;
                second = number;
            } else if (third == null || number > third) {
                third = number;
            }
        }

        // If the third maximum does not exist, return the first (maximum) number
        return third == null ? first.intValue() : third.intValue();
    }
}