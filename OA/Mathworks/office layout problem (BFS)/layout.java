import java.util.*;
//https://leetcode.com/discuss/interview-question/221639/
public class layout {
    public int[] dirx = new int[]{1, -1, 0, 0};
    public int[] diry = new int[]{0, 0, 1, -1};
    public int findMinDist(int w, int h, int n) {
        int[][] grid = new int[w][h];
        for (int i = 0; i < w; i++) {
            Arrays.fill(grid[i], - 1);
        }
        return helper(w, h, n, grid, 0, 0);
    }
    private int helper(int w, int h, int n, int[][] grid, int row, int column) {
        if (n == 0) return bfs(w, h, grid);
        int r = row;
        int c = column;
        if (column >= h) {
            r += column / h;
            c = column % h;
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = r; i < w; i++) {
            for (int j = c; j < h; j++) {
                grid[i][j] = 0;
                int val = helper( w, h, n - 1, grid, i, j + 1);
                minDistance = Math.min(minDistance, val);
                grid[i][j] = -1;
            }
        }
        return minDistance;
    }
    public int bfs(int w, int h, int[][] grid) {
        int[][] dist = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                dist[i][j] = grid[i][j];
            }
        }
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (dist[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0];
            int y = pair[1];
            max = Math.max(max, dist[x][y]);
            for (int dir = 0; dir < 4; dir++) {
                int newX = x + dirx[dir];
                int newY = y + diry[dir];
                if (newX < 0 || newX >= w || newY < 0 || newY >= h) continue;
                if (dist[newX][newY] == -1) {
                    dist[newX][newY] = dist[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        layout test = new layout();
        int w = 2;
        int h = 3;
        int n = 2;
        int res = test.findMinDist(w, h, n);
        System.out.print(res);
    }
}
