package assignments.ten.backtracking;

public class FindAllPossiblePaths {
    public static void main(String[] args) {
        //false represents a river in that cell
        boolean[][] riverMatrix = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        findAllPossiblePathsBacktracking("", riverMatrix, 0 , 0);
    }

    public static void findAllPossiblePathsBacktracking(String p, boolean[][] mat, int r, int c) {
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!mat[r][c]) {
            return;
        }

        //mark the cell as visited by marking it false to avoid recursion cycle
        mat[r][c] = false;

        if (r < mat.length - 1) {
            findAllPossiblePathsBacktracking(p + 'D', mat, r+1, c);
        }

        if (c < mat[0].length - 1) {
            findAllPossiblePathsBacktracking(p + 'R', mat, r, c+1);
        }

        if (r > 0) {
            findAllPossiblePathsBacktracking(p + 'U', mat, r-1, c);
        }

        if (c > 0) {
            findAllPossiblePathsBacktracking(p + 'L', mat, r, c-1);
        }

        //mark the cell as not visited (true) so up-coming recursion calls can consider all the paths
        mat[r][c] = true;
    }
}
