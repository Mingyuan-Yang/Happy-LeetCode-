import java.util.*;
public class solution {
    public int find (int rows, List<String> grid) {
        if (grid == null || grid.size() == 0 || grid.get(0).length() == 0 || rows == 0) return 0;
        int columns = grid.get(0).length();
        int max = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j]) {
                    char c = grid.get(i).charAt(j);
                    dfs(c, i, j, rows, columns, visited, grid);
                    max++;
                }
            }
        }
        return max;
    }
    private void dfs (char c, int i, int j, int rows, int columns, boolean[][] visited, List<String> grid) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || visited[i][j] || grid.get(i).charAt(j) != c) return;
        visited[i][j] = true;
        dfs(c, i + 1, j, rows, columns, visited, grid);
        dfs(c, i - 1, j, rows, columns, visited, grid);
        dfs(c, i, j + 1, rows, columns, visited, grid);
        dfs(c, i, j - 1, rows, columns, visited, grid);
    }
    public static void main(String[] args) {
        concatenated test = new concatenated();
        int rows = 4;
        List<String> grid = new ArrayList<>(Arrays.asList("aabce", "aaacc", "baace", "aaccb"));
        //int res = test.find(rows, grid);
        //System.out.print(res);
    }
}
