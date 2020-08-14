import java.util.*;
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countZero = 0;
        int left = 0;
        int max = 0;
        int len = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                len++;
            } else {
                if (countZero == 0) {
                    len++;
                    countZero++;
                } else {
                    while (nums[left] != 0) {
                        left++;
                        len--;
                    }
                    left++;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }
    public static void main(String[] args) {
        MaxConsecutiveOnesII test1 = new MaxConsecutiveOnesII();
        int[] arr = new int[]{1,0,1,1,0,1,1,};
        int res = test1.findMaxConsecutiveOnes(arr);
        System.out.print(res);
    }
}
