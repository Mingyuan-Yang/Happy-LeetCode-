import java.util.*;
public class maximalsquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean isOne = false;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                isOne = true;
                max = 1;
                break;
            }
        }
        if (isOne == false) {
            for (int i = 1; i < columns; i++) {
                if (matrix[0][i] == '1') {
                    max = 1;
                    break;
                }
            }
        }
        int min = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int itself = matrix[i][j] - '0';
                int leftTop = matrix[i-1][j-1] -'0';
                //System.out.println(leftTop);
                int left = matrix[i][j-1] - '0';
                //System.out.println(left);
                int top = matrix[i-1][j] - '0';
                //System.out.println(top);
                if (itself == 0) {
                    continue;
                }
                if (leftTop == 0 || left == 0 || top == 0) {
                    matrix[i][j] = '1';
                } else {
                    min = Math.min(Math.min(leftTop, top), left) + 1;
                    //matrix[i][j] = Integer.toString(min).charAt(0);
                    matrix[i][j] = (char)(48 + min);
                    max = Math.max(max, min);
                }
            }
        }
        return max * max;
    }
    public static void main(String[] args) {
        maximalsquare test8 = new maximalsquare();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = test8.maximalSquare(matrix);
        System.out.print(res);
    }
}
