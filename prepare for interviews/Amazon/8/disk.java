import java.util.*;
public class disk {
    public int find (int numComputer, int[] hardDiskSpace, int segmentLength) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int[] res = new int[numComputer - segmentLength + 1];
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < hardDiskSpace.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - segmentLength + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && hardDiskSpace[deque.peekLast()] > hardDiskSpace[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i > segmentLength - 2) {
                res[index++] = hardDiskSpace[deque.peekFirst()];
            }
        }
        for (int r : res) {
            min = Math.max(min, r);
        }
        return min;
    }
    public static void main(String[] args) {
        disk test = new disk();
        int numComputer = 8;
        int[] hard = new int[]{1,3,-1,-3,-4,2,5,-7};
        int len = 4;
        int res = test.find(numComputer, hard, len);
        System.out.println(res);
    }
}
