package algorithms.searching;

import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {12, 14, 18, 20},
                {17, 19, 21, 24},
                {22, 23, 25, 26},
                {27, 30, 35, 42}
        };
        System.out.println(Arrays.toString(binary2DSearch(matrix, 19)));
        System.out.println(Arrays.toString(binarySearch2D(matrix, 12)));
    }

    // O(n)
    public static int[] binary2DSearch(int[][] matrix, int target) {
        //Search starts from top right corner of the matrix
        int row = 0, col = matrix.length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return new int[] {row, col};
            }
            // If the target is less than the element at a given column then that means all the values in that column is greater than target, hence ignore that column
            if (target < matrix[row][col]) {
                col--;
            }
            // If the target is greater than the element at a given row then that means all the values in that row is less than target, hence ignore that row
            else {
                row++;
            }
        }
        return new int[] {-1, -1};
    }

    // search in the row provided between the cols provided
    public static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[] {row,mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    //O(logN)
    public static int[] binarySearch2D(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (cols == 0) {
            return new int[]{-1,-1};
        }
        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        int rStart = 0, rEnd = rows - 1;
        int cMid = cols/2;

        //Run the loop till we have 2 rows
        while (rStart < (rEnd - 1)) { //This will keep going until 2 rows are left
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // now we have two rows
        // check whether the target is in the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        //we have eliminated the mid column, so there are 4 cases
        //1st case: search in 1st
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }
        //2nd case: search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }
        //3rd case: search in 3rd half
        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        //4th case: search in 4th half
        else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }
}
