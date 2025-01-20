package assignments.seven;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
public class FindMaxProductInArray {
    public static void main(String[] args) {
        int[] nums = {1,5,4,5};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        //get the max number
        //get the second max number
        //return the product of (max - 1)*(max2 -1)
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (max - 1)*(secondMax -1);
    }
}
