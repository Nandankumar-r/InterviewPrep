package assignments.five;

import java.util.Arrays;
import java.util.List;

public class MatrixReshape {
    public static void main(String[] args) {
        int[][] matrix ={
                {3,7,8},
                {9,11,13}
        };
        int[][] res = matrixReshape(matrix, 3,2);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;

        int[][] ans = new int[r][c];
        int k = 0;

        for (int[] row : nums)
            for (int num : row) {
                ans[k / c][k % c] = num;
                k++;
            }

        return ans;
    }

    /*public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != (mat.length * mat[0].length)) {
            return mat;
        }
        int[][] res = new int[r][c];
        int[] tempMat = new int[mat.length * mat[0].length];
        int index = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                tempMat[index++] = mat[i][j];
            }
        }
        System.out.println(Arrays.toString(tempMat));
        index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = tempMat[index++];
            }
        }
        return res;
    }*/
}
