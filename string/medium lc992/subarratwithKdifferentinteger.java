import java.util.*;
public class subarratwithKdifferentinteger {
    public int subarraysWithKDistinct(int[] A, int K) {
        //这道题和Longest Substring with At Most K Distinct Characters一系列问题的有两个不同。
        // 1. 这里是确切的K个 而不是最多K个。因此拿到最多K个的值，减去最多K-1个的值，即为确切K个的值。
        // 2. at most K系列问题，返回的结果是所有结果中最长的substring，因此每次right指针右移时都要更新最长的值
        //    但是在这道题中，我们要把所有满足要求的substring的个数加起来。res含义：at most k的全部substring个数
        // eg: [1,2,1,2,3] k = 2, res0=1,res1=2,res2=3.res3=4,res4=2
        //                 k = 1, res0=1,res1=1,res2=1,res3=1,res4=1
        //[1,2,1,2,3] k=2 | res0=



        return find(A, K) - find(A, K - 1);
    }
    private int find(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int res = 0;
        for (int right = 0; right < A.length; right++) {
            int c = A[right];
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) count++;
            while (count > K) {
                int x = A[left];
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) count--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        subarratwithKdifferentinteger test4 = new subarratwithKdifferentinteger();
        int[] A = new int[]{1,2,1,2,3};
        int K = 2;
        int res = test4.subarraysWithKDistinct(A, K);
        System.out.print(res);
    }
}
