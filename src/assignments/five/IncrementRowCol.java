package assignments.five;

import java.util.Arrays;
//TODO: Need to REDO without seeing (https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/solutions/425100/java-python-3-2-methods-time-o-m-n-l-and-o-l-codes-w-comment-and-analysis/)
public class IncrementRowCol {
    public static void main(String[] args) {
        int[][] image = {
                {0,1},
                {1,1}
        };
        int res = oddCells(2, 3, image);
        System.out.println(res);
    }

    //Time: O(n)
    //Space: O(n)
    public static int oddCells(int m, int n, int[][] indices) {
        boolean[] oddRows = new boolean[m], oddCols = new boolean[n];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true;
            oddCols[idx[1]] ^= true;
            cntRow += oddRows[idx[0]] ? 1 : -1;
            cntCol += oddCols[idx[1]] ? 1 : -1;
        }
        // even_cols * odd_rows + odd_cols * even_rows
        return (n - cntCol) * cntRow + (m - cntRow) * cntCol;
    }

    // Time: O(n*n)
    //Space: O(m+n)
    /*public static int oddCells(int m, int n, int[][] indices) {
        boolean[] oddRows = new boolean[m], oddCols = new boolean[n];
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
            oddCols[idx[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
        }
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cnt += oddRows[i] ^ oddCols[j] ? 1 : 0; // only cell (i, j) with odd times count of row + column would get odd values.
            }
        }
        return cnt;
    }*/

    //Brute Force
    //Time: O(n*n*n)
    //Space: O(m*n)

    /*public static int oddCells(int m, int n, int[][] indices) {
        int[][] imaginary = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < indices[i].length; j++) {
                if (j == 0) {
                    incrementRow(imaginary, indices[i][j]);
                } else {
                    incrementColumn(imaginary, indices[i][j]);
                }
            }
        }

        System.out.println(Arrays.deepToString(imaginary));
        int oddCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (imaginary[i][j] % 2 != 0)
                    oddCount++;
            }
        }
        return oddCount;
    }
*/
    public static void incrementRow(int[][] imaginary, int j) {
        for (int i = 0; i < imaginary[j].length; i++) {
            imaginary[j][i] += 1;
        }
    }

    public static void incrementColumn(int[][] imaginary, int j) {
        for (int i = 0; i < imaginary.length; i++) {
            imaginary[i][j] += 1;
        }
    }
}
