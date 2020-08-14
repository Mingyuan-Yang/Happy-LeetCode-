import java.util.*;
public class climbingstairs {
    // solution1
    // O(n) O(n)
//    public int climbStairs(int n) {
//        // because we can either climb 1 or 2 steps each time,
//        which means if we want to climb 1 step at last climbing,
//        we need climb from position[n-2]. And if we want to climb 2 steps at last climbing
//        we need climb from position[n-1].
//        Therefore, the total distinct ways we can reach to the position[n] equals to the distinct ways
//        we can reach to the position[n-1] plus(+) the distinct ways we can reach to the position[n-2]
//
//        if (n <= 2) return n;
//        int[] M = new int[n + 1];
//        M[1] = 1;
//        M[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            M[i] = M[i-1] + M[i-2];
//        }
//        return M[n];
//    }

    // solution2
    //O(n) O(1)
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
    public static void main(String[] args) {
        climbingstairs test = new climbingstairs();
        int a = test.climbStairs(5);
        System.out.print(a);
    }
}
