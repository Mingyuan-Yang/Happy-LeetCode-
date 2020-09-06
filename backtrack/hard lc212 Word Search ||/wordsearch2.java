import java.util.*;
public class wordsearch2 {
    public List<String> findWords(char[][] board, List<String> words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (String str : words) {
                    if (str.charAt(0) == board[i][j]) {
                        if (dfs(i, j, board, str, 0)) {
                            res.add(str);
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean dfs(int i, int j, char[][] board, String s, int index) {
        if (index == s.length()) return true;
        int rows = board.length;
        int columns = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= columns || s.charAt(index) != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean flag = dfs(i - 1, j, board, s, index + 1) || dfs(i + 1, j, board, s, index + 1)
                       || dfs(i, j - 1, board, s, index + 1) || dfs(i, j + 1, board, s, index + 1);
        board[i][j] = c;
        return flag;
    }
    public static void main(String[] args) {
        wordsearch2 test = new wordsearch2();
        char[][] board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        List<String> words = new ArrayList<>(Arrays.asList("oath","pea","eat","rain","rvlf"));
        List<String> res = test.findWords(board, words);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
