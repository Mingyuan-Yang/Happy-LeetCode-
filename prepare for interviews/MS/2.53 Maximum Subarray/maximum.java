public class maximum {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum < 0) {
                preSum = nums[i];
            } else {
                preSum += nums[i];
            }
            res = Math.max(res, preSum);
        }
        return res;
    }
}
