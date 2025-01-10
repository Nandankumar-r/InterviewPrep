package assignments.seven;

import java.util.Arrays;

//https://leetcode.com/problems/largest-perimeter-triangle/description/
//Triangle if sum(2 side) > third side
public class IsTriangleOrNot {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--){
            if(nums[i-1] + nums[i-2] > nums[i])
                return nums[i] + nums[i-1] + nums[i-2];
        }
        return 0;
    }
}
