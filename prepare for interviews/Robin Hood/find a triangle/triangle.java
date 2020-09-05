public class triangle {
    public int[][] findTriangle(int[][] grid) {
        int[][] res = new int[2][2];
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    res[0][0] = i;
                    res[0][1] = j;
                    while (i < row && grid[i][j] == 0) {
                        i++;
                    }
                    i--;
                    while (j < column && grid[i][j] == 0) {
                        j++;
                    }
                    j--;
                    res[1][0] = i;
                    res[1][1] = j;
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        triangle test = new triangle();
        int[][] grid = new int[][]{{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int[][] res = test.findTriangle(grid);
        System.out.println(res[0][0] + " " + res[0][1]);
        System.out.println(res[1][0] + " " + res[1][1]);
    }
}
