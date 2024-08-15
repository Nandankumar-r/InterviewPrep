package assignments.five;

public class KadaneSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Sum: " + maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int max_current = nums[0], max_global = nums[0], endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            max_current = Math.max(nums[i], max_current + nums[i]);
            if (max_current > max_global) {
                max_global = max_current;
                endIndex = i;
            }
        }

        //To Print the subarray
        int startIndex = endIndex, temp = max_global;
        while(startIndex > 0) {
            temp -= nums[startIndex];
            if (temp == 0)
                break;
            startIndex--;
        }
        System.out.print("Elements are: ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return max_global;
    }
}
