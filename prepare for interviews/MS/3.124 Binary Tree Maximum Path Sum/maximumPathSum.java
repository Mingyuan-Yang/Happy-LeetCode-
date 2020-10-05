public class maximumPathSum {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
    }
    private int helper(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left, max));
        int right = Math.max(0, helper(root.right, max));
        int curr = root.val + left + right;
        max[0] = Math.max(max[0], curr);
        return root.val + Math.max(left, right);
    }
}
