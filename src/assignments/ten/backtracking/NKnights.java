package assignments.ten.backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(findAllNKnights(board, 0));
    }

    public static int findAllNKnights(boolean[][] board, int r) {
        // Base case: if the current row index equals the board size, it means all queens are placed safely.
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int c = 0; c < board.length; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = true;
                count += findAllNKnights(board, r + 1);
                board[r][c] = false;
            }
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int r, int c) {
        if (isValidPos(board, r - 2, c - 1)) {
            if (board[r - 2][c - 1]) {
                return false;
            }
        }

        if (isValidPos(board, r - 2, c + 1)) {
            if (board[r - 2][c + 1]) {
                return false;
            }
        }

        if (isValidPos(board, r - 1, c - 2)) {
            if (board[r - 1][c - 2]) {
                return false;
            }
        }

        if (isValidPos(board, r - 1, c + 2)) {
            if (board[r - 1][c + 2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPos(boolean[][] board, int r, int c) {
        if (r >= 0 && r <= board.length - 1 && c >= 0 && c <= board.length - 1) {
            return true;
        }
        return false;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row){
                if (ele) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
