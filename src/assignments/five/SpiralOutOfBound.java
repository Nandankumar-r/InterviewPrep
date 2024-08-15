package assignments.five;

import java.util.Arrays;

public class SpiralOutOfBound {
    public static void main(String[] args) {
        int[][] res = spiralMatrixIII(3, 4, 1, 2);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; //R -> D -> L -> U
        int n = rows*cols;
        int[][] res = new int[n][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count = 1; //To Keep track of number of elements inserted, should be n at the end.
        int step = 1; //In spiral traversal we need to extend the traversal for every right/left traversal
        int directionIndex = 0; //Points to the current direction
        while (count < n) {
            for (int index = 0; index < 2; index++) {
                int dr = directions[directionIndex % 4][0];
                int dc = directions[directionIndex % 4][1];
                for (int i = 0; i < step; i++) {
                    rStart += dr;
                    cStart += dc;
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }
                }
                directionIndex++;
            }
            step++;
        }
        return res;
    }
}
