package assignments.seven;

import java.util.Arrays;

public class FindAllCellDistance {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allCellsDistOrder(2,2,0,1)));
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows*cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int twoDIndex = i * cols + j;
                res[twoDIndex][0] = i;
                res[twoDIndex][1] = j;
            }
        }
        Arrays.sort(res, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return d1 - d2;
        });
        return res;
    }
}
