package assignments.five;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the size of the array ");
        int n = scanner.nextInt();
        System.out.print("Please enter an array of integer ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        int[] res = buildArray(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
