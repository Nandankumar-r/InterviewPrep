package leetcodeDaily;

public class MinimumToOneArray {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,0};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                //flip next 3 bits
                nums[i] = nums[i] == 0 ? 1 : 0;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                res += 1;
            }
        }
        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {
            return -1;
        }

        return res;
    }
}
