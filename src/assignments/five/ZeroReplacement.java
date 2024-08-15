package assignments.five;

// fr = first row
// fc = first col

import java.util.Arrays;
import java.util.List;

// Use first row and first column as markers.
// if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
// that later this respective row and col must be marked 0;
// And because you are altering first row and column,
// you need to  have two variables to track their own status.
// So, for ex, if any one of the first row is 0, fr = 0,
// and at the end set all first row to 0;
public class ZeroReplacement {
    public static void main(String[] args) {
        int[][] matrix ={
                {0,7,8},
                {9,0,13},
                {1,2,1},
                {22,12,87}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (fr) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
