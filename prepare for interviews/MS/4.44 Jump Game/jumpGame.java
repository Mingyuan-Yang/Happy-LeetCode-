public class jumpGame {
    public boolean canJump(int[] nums) {
        int canReach = 0;
        for (int i = 0; i < nums.length && i <= canReach; i++) {
            canReach = Math.max(canReach, nums[i] + i);
            if (canReach >= nums.length) return true;
        }
        return false;
    }
}
