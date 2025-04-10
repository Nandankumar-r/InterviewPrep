package assignments.ten.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch search = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String searchString = "ABCESEEEFS";
        System.out.println(search.exist(board, searchString));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (word.length() == index) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i, j - 1, index + 1)
                || dfs(board, word, i, j + 1, index + 1);

        board[i][j] = temp;
        return found;
    }

}
