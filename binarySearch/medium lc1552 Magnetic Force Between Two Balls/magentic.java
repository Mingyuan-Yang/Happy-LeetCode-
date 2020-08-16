import java.util.*;
public class magentic {
    public int maxDistance(int[] positions, int m) {
        Arrays.sort(positions);
        int left = 1;
        int right = positions[positions.length-1]- positions[0];
        int max = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (minDifference(mid, positions, m)) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
    public boolean minDifference(int minDistance, int[] positions, int m) {
        int res = 1;
        int cur = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - cur >= minDistance) {
                res++;
                cur = positions[i];
            }
        }
        return res >= m;
    }
    public static void main(String[] args) {
        magentic test = new magentic();
        int[] positions = new int[]{5,4,3,2,1,1000000000};
        int m = 2;
        int res = test.maxDistance(positions, m);
        System.out.print(res);
    }
}
