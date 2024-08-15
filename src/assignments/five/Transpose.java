package assignments.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transpose {
    public static void main(String[] args) {
        int[][] image = {
                {1,2,3},
                {4,5,6}
        };
        int[][] res = transpose(image);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}
