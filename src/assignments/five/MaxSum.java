package assignments.five;

import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the row size of the 2D array ");
        int m = scanner.nextInt();
        System.out.print("Please enter the column size of the 2D array ");
        int n = scanner.nextInt();
        System.out.print("Please enter 2D array of integer ");
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int res = maximumWealth(nums);
        System.out.println(res);
    }
    public static int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int largest = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            if (sum > largest)
                largest = sum;
        }
        return largest;
    }
}
