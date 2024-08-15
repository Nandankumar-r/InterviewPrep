package assignments.five;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length, curr = 1;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            res[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n-1; i >=0 ; i--) {
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }
}
