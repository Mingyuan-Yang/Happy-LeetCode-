import java.util.*;
public class triangles {
    //problem2
    public List<List<Integer>> findTriangles(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, i, j);
                    int x = 1;
                    int y = 1;
                    while (i + x < row && grid[i + x][j] == 0) {
                        x++;
                    }
                    while (j + y < column && grid[i][j + y] == 0) {
                        y++;
                    }
                    for (int height = i; height < i + x; height++) {
                        for (int width = j; width < j + y; width++) {
                            grid[height][width] = 1;
                        }
                    }
                    Collections.addAll(list, i + x - 1, j + y - 1);
                    res.add(list);
                }
            }
        }
        return res;
    }

    //problem3
    //O(m*n)
    //O(m*n)
    public List<List<Integer>> findRandomShapes(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    List<Integer> list = new ArrayList<>();
                    dfs(grid, i, j, rows, columns, list);
                    res.add(list);
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int i, int j, int rows, int columns, List<Integer> list) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] != 0) return;
        Collections.addAll(list, i, j);
        grid[i][j] = 1;
        dfs(grid, i - 1, j, rows, columns, list);
        dfs(grid, i + 1, j, rows, columns, list);
        dfs(grid, i, j - 1, rows, columns, list);
        dfs(grid, i, j + 1, rows, columns, list);
    }
    public static void main(String[] args) {
        triangles test = new triangles();
        int[][] grid = new int[][]{{1,0,0,0,1},{1,1,1,1,0},{0,0,0,1,0},{0,0,0,1,0}};
        List<List<Integer>> res = test.findTriangles(grid);
//        for (int i = 0; i < res.size(); i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(res.get(i).get(j) + " ");
//            }
//            System.out.println(" ");
//        }


        int[][] grid2 = new int[][]{{1,0,0,0,1}, {1,1,1,0,0}, {0,0,0,1,0}, {0,1,0,1,0}};
        List<List<Integer>> res2 = test.findRandomShapes(grid2);
        for (int i = 0; i < res2.size(); i++) {
            for (int j = 0; j < res2.get(i).size() - 1; j++) {
                System.out.print(res2.get(i).get(j) + "," + res2.get(i).get(j + 1) + "|");
                j ++;
            }
            System.out.println(" ");
        }
    }
}
