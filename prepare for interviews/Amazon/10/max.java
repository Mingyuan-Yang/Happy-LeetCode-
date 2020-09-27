public class max {
    public int maxScore(int[][] grid) {
        // Assume there is at least one element
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        // Init
        dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
        for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
        // DP
        for (int i = 1; i < r; ++i) { // row by row
            for (int j = 1; j < c; ++j) {
                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
                } else {
                    int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
                    int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
                    dp[i][j] = Math.max(score1, score2);
                }
            }
        }
        return dp[r - 1][c - 1];
    }
    public static void main(String[] args) {
        max test = new max();
        int[][] grid = new int[][]{{1,2,3},{4,5,1}};
        int res = test.maxScore(grid);
        System.out.print(res);
    }
}
