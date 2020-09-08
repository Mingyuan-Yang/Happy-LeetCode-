import java.util.*;
public class findfind {
    //problem1
    public List<List<Integer>> find(int[][] grid, int[] source) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int x = source[0];
        int y = source[1];
        for (int i = 0; i < columns; i++) {
            if (i == y) continue;
            if (grid[x][i] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(i);
                res.add(list);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (i == x) continue;
            if (grid[i][y] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(y);
                res.add(list);
            }
        }
        return res;
    }
    //problem2
    public boolean find2(int[][] grid, int[] source) {
        int x = source[0];
        int y = source[1];
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        dfs(grid, x, y, rows, columns, visited);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false){
                    return false;
                }
            }
        }
        return true;
    }
    private void dfs(int[][] grid, int i, int j, int rows, int columns, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] != 0 || visited[i][j]) return;
        if (grid[i][j] == 0) visited[i][j] = true;
        dfs(grid, i + 1, j, rows, columns, visited);
        dfs(grid, i - 1, j, rows, columns, visited);
        dfs(grid, i, j - 1, rows, columns, visited);
        dfs(grid, i, j + 1, rows, columns, visited);
    }

    //problem3
    public List<List<int[]>> find3(int[][] grid, int[] source, int[] target) {
        List<List<int[]>> res = new ArrayList<>();
        int sX = source[0];
        int sY = source[1];
        int tX = target[0];
        int tY = target[1];
        int rows = grid.length;
        int columns = grid[0].length;
        int treasure = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) treasure++;
            }
        }
        boolean[][] visited = new boolean[rows][columns];
        dfs3(grid, sX, sY, tX, tY, treasure, visited, rows, columns, res, new ArrayList<>());
        if (res.size() < 1) return new ArrayList<>();
        int shortest = res.get(0).size();
        int index = -1;
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i).size() < shortest) {
                shortest = res.get(i).size();
                index = i;
            }
        }
        List<List<int[]>> res2 = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() == shortest) {
                res2.add(res.get(i));
            }
        }
        return res2;
    }
    private void dfs3(int[][] grid, int i, int j, int tX, int tY, int treasure, boolean[][] visited, int rows, int columns,
                     List<List<int[]>> res, List<int[]> list) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] == -1 || visited[i][j]) return;
        list.add(new int[]{i, j});
        if (grid[i][j] == 1) treasure--;
        visited[i][j] = true;
        if (i == tX && j == tY && treasure == 0) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            visited[i][j] = false;
            return;
        }
        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            dfs3(grid, newi, newj, tX, tY, treasure, visited, rows, columns, res, list);
        }
        visited[i][j] = false;
        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        findfind test = new findfind();
        int[][] grid = new int[][]{{1,1,0,1},{0,1,0,1},{0,0,-1,0}};
        int[] source = new int[]{1,2};
        List<List<Integer>> res = test.find(grid, source);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                //System.out.print(res.get(i).get(j) + " ");
            }
            //System.out.println(" ");
        }

        int[][] grid2 = new int[][]{{0,-1,-1,0},{-1,0,0,0},{-1,-1,-1,0},{0,0,-1,0}};
        int[] source2 = new int[]{2,3};
        boolean res2 = test.find2(grid2, source2);
        //System.out.print(res2);


        int[][] grid3 = new int[][]{{ 1,0,0,0,0},{0,-1,-1,0,0},{0,-1,0,1, 0},{-1,0,0,0,0},
                {0,1,-1,0,0}, {0,0,0,0,0}};
        int[] source3 = new int[]{5,0};
        int[] target3 = new int[]{0,4};
        List<List<int[]>> res3 = test.find3(grid3, source3, target3);
        for (int i = 0; i < res3.size(); i++) {
            for (int j = 0; j < res3.get(i).size(); j++) {
                System.out.print(res3.get(i).get(j)[0] + "," + res3.get(i).get(j)[1] + " ");
            }
            System.out.println(" ");
        }
    }
}
