public class maximum {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public int maxDepth(TreeNode root) {
        int[] max = new int[1];
        return helper(root, max);
    }
    private int helper(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        max[0] = Math.max(max[0], Math.max(left, right) + 1);
        return Math.max(left, right) + 1;
    }
}
