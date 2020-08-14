import java.util.*;
public class painting {
    public int minCost(int[][] costs) {
        // 非常巧妙的方法！注意Math.MIN 只能同时比较两个！
        // TIME O(N) SPACE O(1)
        if (costs == null || costs.length == 0) return 0;
        if (costs.length == 1) return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
        int len = costs.length;
        for (int i = 1; i < len; i++) {
            costs[i][0] = Math.min(costs[i-1][1], costs[i-1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i-1][0], costs[i-1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i-1][0], costs[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(costs[len-1][0], costs[len-1][1]), costs[len-1][2]);
    }
    public static void main(String[] args) {
        painting test7 = new painting();
        int[][] costs = new int[][]{{17,2,17}, {16,16,5},{14,3,19}};
        int a = test7.minCost(costs);
        System.out.print(a);
    }
}
