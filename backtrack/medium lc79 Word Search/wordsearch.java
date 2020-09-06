import java.util.*;
public class wordsearch {
    public boolean word(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, word, board, 0)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, String word, char[][] board, int index) {
        if (index == word.length()) return true;
        int rows = board.length;
        int columns = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= columns || word.charAt(index) != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean flag = dfs(i + 1, j, word, board, index + 1) ||
                       dfs(i - 1, j, word, board, index + 1) ||
                       dfs(i, j + 1, word, board, index + 1) ||
                       dfs(i, j - 1, word, board, index + 1);
        board[i][j] = c;
        return flag;
    }

    public static void main(String[] args) {
        wordsearch test = new wordsearch();
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        boolean res1 = test.word(board, word1);
        boolean res2 = test.word(board, word2);
        boolean res3 = test.word(board, word3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

}
