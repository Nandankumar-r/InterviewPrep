package assignments.five;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix ={
                {3,7,8},
                {9,11,13},
                {1, 2,1},
                {22, 12,87}
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int first_row = 0, last_row = m - 1, first_col = 0, last_col = n -1;
        List<Integer> list = new LinkedList<>();

        while (first_row <= last_row && first_col <= last_col) {
            for (int i = first_row; i <= last_col; i++) {
                list.add(matrix[first_row][i]);
            }
            first_row++;
            for (int i = first_row; i <= last_row; i++) {
                list.add(matrix[i][last_col]);
            }
            last_col--;

            if (first_row <= last_row) {
                for (int i = last_col; i >= first_col; i--) {
                    list.add(matrix[last_row][i]);
                }
                last_row--;
            }

            if (first_col <= last_col) {
                for (int i = last_row; i >= first_row; i--) {
                    list.add(matrix[i][first_col]);
                }
                first_col++;
            }
        }
        return list;
    }
}
