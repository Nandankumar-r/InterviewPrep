package assignments.five;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateSpiralMatrix {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] generateMatrix(int n) {
        int first_row = 0, last_row = n - 1, first_col = 0, last_col = n -1, num = 1;
        int[][] res = new int[n][n];

        while (first_row <= last_row && first_col <= last_col) {
            for (int i = first_row; i <= last_col; i++) {
                res[first_row][i] = num;
                num++;
            }
            first_row++;
            for (int i = first_row; i <= last_row; i++) {
                res[i][last_col] = num;
                num++;
            }
            last_col--;

            if (first_row <= last_row) {
                for (int i = last_col; i >= first_col; i--) {
                    res[last_row][i] = num;
                    num++;
                }
                last_row--;
            }

            if (first_col <= last_col) {
                for (int i = last_row; i >= first_row; i--) {
                    res[i][first_col] = num;
                    num++;
                }
                first_col++;
            }
        }
        return res;
    }
}
