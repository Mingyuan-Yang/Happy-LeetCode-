import java.util.*;

public class minimum {
    public int minDays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 1;
        M[2] = 2;
        for (int i = 3; i <= n; i++) {
            if (n / i == 3 && n % i == 0) return M[i] + 1;
            if (n / i == 2 && n % i == 0) return M[i] + 1;
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0 && i % 2 == 0) {
                min = Math.min(Math.min(min, M[i / 3] + 1), M[i / 2] + 1);
            } else if (i % 3 == 0) {
                min = Math.min(min, M[i / 3] + 1);
            } else if (i % 2 == 0) {
                min = Math.min(min, M[i / 2] + 1);
            }
            min = Math.min(min, M[i - 1] + 1);
            M[i] = min;

        }
        return M[n];
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, 0);
//        map.put(1, 1);
//        map.put(2, 2);
//        for (int i = 3; i <= n; i++) {
//            int min = Integer.MAX_VALUE;
//            if (i == n / 3 && n % i == 0) return map.get(i) + 1;
//            if (i == n / 2 && n % i == 0) return map.get(i) + 1;
//            if (i % 3 == 0 && i % 2 == 0) {
//                min = Math.min(Math.min(min, map.get(i/3)+1), map.get(i/2)+1);
//                //min = Math.min(Math.min(min, M[i / 3] + 1), M[i / 2] + 1);
//            } else if (i % 3 == 0) {
//                min = Math.min(min, map.get(i/3)+1);
//                //min = Math.min(min, M[i / 3] + 1);
//            } else if (i % 2 == 0) {
//                min = Math.min(min, map.get(i/2)+1);
//                //min = Math.min(min, M[i / 2] + 1);
//            }
//            min = Math.min(min, map.get(i-1)+1);
//            //min = Math.min(min, M[i-1] + 1);
//            map.put(i, min);
//            //M[i] = min;
//        }
//        return map.get(n);
//        //return M[n];
    }
    public static void main(String[] args) {
        minimum test = new minimum();
        int n = 84806671;
        int res = test.minDays(n);
        System.out.print(res);
    }
}

