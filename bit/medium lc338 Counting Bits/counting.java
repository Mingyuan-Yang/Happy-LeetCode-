public class counting {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp;
    }
    public static void main(String[] args) {
        counting test = new counting();
        int num = 5;
        int[] res = test.countBits(num);
        int i = 0;
        while (i <= num) {
            System.out.println(res[i]);
            i++;
        }
    }
}
