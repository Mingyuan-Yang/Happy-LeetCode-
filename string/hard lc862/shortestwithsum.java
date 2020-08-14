import java.util.*;
public class shortestwithsum {
    public int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = A[i] + preSum[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int res = preSum.length;
        for (int i = 1; i < A.length + 1; i++) {
            while (deque.size() > 0 && preSum[i] - preSum[deque.peekFirst()] >= K) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (deque.size() > 0 && preSum[i] < preSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res == preSum.length ? -1 : res;
    }
    public static void main(String[] args) {
        shortestwithsum test5 = new shortestwithsum();
        int[] A = new int[]{84,-37,32,40,95};
        int K = 167;
        int r = test5.shortestSubarray(A, K);
        System.out.print(r);
    }
}
