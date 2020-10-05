public class wordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, rows, columns, 0)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, char[][] board, String word, int rows, int columns, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= rows || j < 0 || j >= columns || word.charAt(index) != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean flag = dfs(i + 1, j, board, word, rows, columns, index + 1) ||
                       dfs(i - 1, j, board, word, rows, columns, index + 1) ||
                       dfs(i, j + 1, board, word, rows, columns, index + 1) ||
                       dfs(i, j - 1, board, word, rows, columns, index + 1);
        board[i][j] = c;
        return flag;

    }
}
