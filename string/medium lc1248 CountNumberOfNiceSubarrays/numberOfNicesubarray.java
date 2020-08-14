import java.util.*;
public class numberOfNicesubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        return find(nums, k) - find(nums, k - 1);
    }
    private int find(int[] nums, int k) {
        int count = 0; // count odd numbers in sliding window
        int left = 0; // begin index of sliding window
        int max = 0;
        int len = 0;
        for (int right = 0; right < nums.length; right++) {
            int c = nums[right];
            if (isOdd(c)) {
                count++;
            }
            while (count > k) {
                int x = nums[left];
                if (isOdd(x)) {
                    count--;
                }
                left++;
                len++;
            }
            max += right - left + 1;
        }
        return max;
    }
    private boolean isOdd(int a) {
        if (a % 2 == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        numberOfNicesubarray test3 = new numberOfNicesubarray();
        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        int res = test3.numberOfSubarrays(nums, k);
        System.out.print(res);
    }
}
