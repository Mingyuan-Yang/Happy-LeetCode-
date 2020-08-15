import java.util.*;
public class longest {
         //time : O(n^2)
         //space: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] M = new int[nums.length];
        M[0] = 1;
        int global_max = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(M[j], max);
                }
            }
            M[i] = max + 1;
            global_max = Math.max(M[i], global_max);
        }
        return global_max;
    }

    public static void main(String[] args) {
        longest l = new longest();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int res = l.lengthOfLIS(nums);
        System.out.print(res);
    }
}
