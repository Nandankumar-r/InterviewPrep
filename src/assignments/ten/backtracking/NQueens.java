package assignments.ten.backtracking;

//Time - O(n!)
//Space - O(n*n)
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(findAllNQueens(board, 0));
    }

    public static int findAllNQueens(boolean[][] board, int r) {
        // Base case: if the current row index equals the board size, it means all queens are placed safely.
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        // Try placing a queen in every column of the current row.
        for (int c = 0; c < board.length; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = true;
                // Recursively try to place the rest of the queens in the next row.
                count += findAllNQueens(board, r+1);
                // Remove the queen (backtrack) to try another column.
                board[r][c] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        // Check the vertical column above (r, c) because queens are placed in previous rows only.
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }

        //check the left vertical diagonal from where the queen is placed
        // maxLeft determines the number of steps we can move diagonally up-left without going off the board.
        // Explanation:
        //   - 'r' is the current row, and 'c' is the current column.
        //   - We cannot go more than 'r' steps upward or 'c' steps left, so the maximum safe steps is the smaller of these two numbers.
        int maxLeft = Math.min(r, c);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[r - i][c - i]) {
                return false;
            }
        }

        //check the right vertical diagonal from where the queen is placed
        // maxRight determines the number of steps we can move diagonally up-right without going off the board.
        // Explanation:
        //   - 'r' is the current row, so we can move up at most 'r' steps.
        //   - For moving right, we have to consider the board's width. The current column is 'c', and the last column is at index board.length - 1.
        //   - Thus, the maximum steps to the right is board.length - c - 1.
        //   - Math.min(r, board.length - c - 1) gives the number of steps we can take without leaving the board.
        int maxRight = Math.min(r, board.length - c - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[r - i][c + i]) {
                return false;
            }
        }
        return true;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row){
                if (ele) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
