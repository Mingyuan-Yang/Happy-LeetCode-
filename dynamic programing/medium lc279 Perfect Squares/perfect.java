public class perfect {
    public int numSquares(int n) {
        int[] M = new int[n + 1];
        M[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i >= j * j) {
                min = Math.min(M[i - j * j] + 1, min);
                j++;
            }
            M[i] = min;
        }
        return M[n];
    }
    public static void main(String[] args) {
        perfect test = new perfect();
        int n = 12;
        int res = test.numSquares(n);
        System.out.print(res);
    }
}
