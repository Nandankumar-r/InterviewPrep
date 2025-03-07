package assignments.ten.backtracking;

//O(9^(n^2)) 9 power (n squared)
public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
               //0  1  2  3  4  5  6  7  8
                {3, 0, 6, 5, 0, 8, 4, 0, 0},//0
                {5, 2, 0, 0, 0, 0, 0, 0, 0},//1
                {0, 8, 7, 0, 0, 0, 0, 3, 1},//2
                {0, 0, 3, 0, 1, 0, 0, 8, 0},//3 (rowStart, colStart) = ((5-(5%3)), (7-(7%3))) --> (3, 6)
                {9, 0, 0, 8, 6, 3, 0, 0, 5},//4
                {0, 5, 0, 0, 9, 0, 6, 0, 0},//5 (row, col) = (5, 7)
                {1, 3, 0, 0, 0, 0, 2, 5, 0},//6
                {0, 0, 0, 0, 0, 0, 0, 7, 4},//7
                {0, 0, 5, 2, 0, 6, 3, 0, 0}// 8
        };
        if (solveSudoku(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve given sudoku");
        }
    }

    public static boolean solveSudoku(int[][] board) {
        int n = board.length;
        int row = -1, col = -1;
        boolean emptyLeft = true; // Flag to check if there are still any empty cells on the board

        // Loop through every cell in the board to find an empty one (represented by 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false; //found one empty cell
                    break;
                }
            }
            if (!emptyLeft) {// If an empty cell has been found, exit the outer loop as well
                break;
            }
        }

        //No empty cells left hence must be solved
        if (emptyLeft) {
            return true;
        }

        // Try placing numbers 1 through 9 into the empty cell (row, col)
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                // Recursively try to solve the rest of the board with this number in place
                if (solveSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = 0;// If not successful, reset the cell (backtracking) and try the next number
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check the row: Make sure that 'num' is not already in the same row.
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column: Make sure that 'num' is not already in the same column.
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Calculate the size of the subgrid.
        int sqrt = (int) (Math.sqrt(board.length));
        // "row - row % sqrt" rounds down the row index to the nearest multiple of sqrt.
        // For example, if row = 5 and sqrt = 3, then row % 3 is 2, and row - 2 is 3.
        // This means that the subgrid starts at row index 3 (covering rows 3, 4, and 5).
        // If col = 7 and sqrt = 3, then col % 3 is 1, and col - 1 is 6.
        // This means that the subgrid starts at column index 6 (covering columns 6, 7, and 8).
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        // Loop through all cells in the subgrid starting at (rowStart, colStart)
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void display(int[][] board) {
        for(int[] row : board) {
            for(int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
