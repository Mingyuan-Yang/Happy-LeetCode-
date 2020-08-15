public class minimal {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows-1][columns-1];
    }
    public static void main(String[] args) {
        minimal test = new minimal();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int res = test.minPathSum(grid);
        System.out.print(res);
    }
}
