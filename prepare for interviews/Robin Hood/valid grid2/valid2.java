import java.util.*;
public class valid2 {
    public boolean isValidNonogram(int[][] grid, int[][] row, int[][] column) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (rows != row.length || columns != column.length) {
            return false;
        }
        return isValidRow(grid, row, rows, columns) && isValidColumn(grid, column, rows, columns);
    }
//    private boolean isValidRow(int[][] grid, int[][] row, int rows, int columns) {
//        for (int i = 0; i < rows; i++) {
//            int p = 0;
//            for (int j = 0; j < columns; j++) {
//                if (grid[i][j] == 0) {
//                    if (row[i].length == 0 || p >= row[i].length) return false;
//                    for (int k = 0; k < row[i][p]; k++) {
//                        if (j + k >= columns || grid[i][j+k] != 0) {
//                            return false;
//                        }
//                    }
//                    j += row[i][p++] - 1;
//                }
//            }
//            if (p != row[i].length) return false;
//        }
//        return true;
//    }
    private boolean isValidRow(int[][] grid, int[][] row, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            int p = 0;
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    if (row[i].length == 0 || p > row[i].length) return false;
                    int k = 0;
                    while (j + k < columns  && grid[i][j + k] == 0) {
                        k++;
                    }
                    if (k != row[i][p++]) return false;
                    j += k - 1;
                }
            }
            if (p != row[i].length) return false;
        }
        return true;
    }
    private boolean isValidColumn(int[][] grid, int[][] column, int rows, int columns) {
        for (int i = 0; i < columns; i++) {
            int p = 0;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 0) {
                    if (column[i].length == 0 || p >= column[i].length) return false;
                    int k = 0;
                    while (j + k < rows && grid[j + k][i] == 0) {
                        k++;
                    }
                    if (k != column[i][p++]) return false;
                    j += k - 1;
                }
            }
            if (p != column[i].length) return false;
        }
        return true;
    }
//    private boolean isValidColumn(int[][] grid, int[][] column, int rows, int columns) {
//        for (int i = 0; i < columns; i++) {
//            int p = 0;
//            for (int j = 0; j < rows; j++) {
//                if (grid[j][i] == 0) {
//                    if (column[i].length == 0 || p >= column[i].length) return false;
//                    for (int k = 0; k < column[i][p]; k++) {
//                        if (k + j >= rows || grid[j + k][i] != 0) return false;
//                    }
//                    j += column[i][p++] - 1;
//                }
//            }
//            if (p != column[i].length) return false;
//        }
//        return true;
//    }
    public static void main(String[] args) {
        valid2 test = new valid2();
        int[][] grid = new int[][]{{1,1,1,1}, {0,1,1,1}, {0,1,0,0}, {1,1,0,1},{0,0,1,1}};
        int[][] row = new int[][]{{},{1},{1,2},{1},{2}};
        int[][] column = new int[][]{{2,1},{1},{2},{1}};
        boolean res = test.isValidNonogram(grid, row, column);
        System.out.print(res);
    }
}
