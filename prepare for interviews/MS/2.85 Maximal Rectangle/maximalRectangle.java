public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] width = new int[rows][columns];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) width[i][j] = 1;
                    else width[i][j] = width[i][j - 1] + 1;
                } else {
                    width[i][j] = 0;
                }
                int minWidth = width[i][j];
                for (int up = i; up >= 0; up--) {
                    int height = i - up + 1;
                    minWidth = Math.min(minWidth, width[up][j]);
                    max = Math.max(max, minWidth * height);
                }
            }
        }
        return max;
    }
}
