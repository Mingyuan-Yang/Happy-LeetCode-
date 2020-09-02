import java.util.*;
public class triangles {
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
    public static void main(String[] args) {
        triangles test = new triangles();
        int[][] grid = new int[][]{{1,0,0,0,1},{1,1,1,1,0},{0,0,0,1,0},{0,0,0,1,0}};
        List<List<Integer>> res = test.findTriangles(grid);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
