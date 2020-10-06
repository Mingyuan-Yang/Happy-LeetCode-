public class spiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int rowsTop = 0;
        int rowsBottom = n - 1;
        int columnsLeft = 0;
        int columnsRight = n - 1;
        while (count <= n * n) {
            for (int i = columnsLeft; i <= columnsRight; i++) {
                res[rowsTop][i] = count;
                count++;
            }
            rowsTop++;
            for (int i = rowsTop; i <= rowsBottom; i++) {
                res[i][columnsRight] = count;
                count++;
            }
            columnsRight--;
            for (int i = columnsRight; i >= columnsLeft; i--) {
                res[rowsBottom][i] = count;
                count++;
            }
            rowsBottom--;
            for (int i = rowsBottom; i >= rowsTop; i--) {
                res[i][columnsLeft] = count;
                count++;
            }
            columnsLeft++;
        }
        return res;
    }
}
