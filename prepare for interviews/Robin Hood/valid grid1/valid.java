import java.util.*;
public class valid {
    //O(n*n)
    public boolean isValid(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> columnSet = new HashSet<>();
            int minRow = Integer.MAX_VALUE;
            int maxRow = Integer.MIN_VALUE;
            int minColumn = minRow;
            int maxColumn = maxRow;
            for (int j = 0; j < n; j++) {
                if (!rowSet.contains(grid[i][j])) {
                    rowSet.add(grid[i][j]);
                    minRow = Math.min(minRow, grid[i][j]);
                    maxRow = Math.max(maxRow, grid[i][j]);
                } else {
                    return false;
                }
                if (!columnSet.contains(grid[j][i])) {
                    columnSet.add(grid[j][i]);
                    minColumn = Math.min(minColumn, grid[j][i]);
                    maxColumn = Math.max(maxColumn, grid[j][i]);
                } else {
                    return false;
                }
            }
            if (minRow != 1 || minColumn != 1 || maxRow != n || maxColumn != n) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        valid test = new valid();
        int[][] grid = new int[][]{{1,3,2}, {3,1,2}, {2,3,1}};
        boolean res = test.isValid(grid);
        System.out.println(res);
    }
}
