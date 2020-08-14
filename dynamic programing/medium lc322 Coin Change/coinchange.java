import java.util.*;
public class coinchange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] M = new int[amount + 1];
        for (int i = 1; i < M.length; i++) {
            M[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && M[i - coins[j]] != Integer.MAX_VALUE) {
                    M[i] = Math.min(M[i], 1 + M[i - coins[j]]);
                }
            }
        }
        return M[amount] == Integer.MAX_VALUE ? -1 : M[amount];
    }
    public static void main(String[] args) {
        coinchange t = new coinchange();
        int[] coins = new int[]{1,2,5};
        int amount = 12;
        int res = t.coinChange(coins, amount);
        System.out.print(res);
    }
}
