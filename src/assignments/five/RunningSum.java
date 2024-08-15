package assignments.five;

import java.util.Arrays;
import java.util.Scanner;

public class RunningSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the size of the array ");
        int n = scanner.nextInt();
        System.out.print("Please enter an array of integer ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        int[] res = runningSum(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
