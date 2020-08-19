public class range {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right, TreeNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] res = new int[1];
        helper(root, L, R, res);
        return res[0];
    }
    private int helper(TreeNode root, int L, int R, int[] res) {
        if (root == null) return 0;
        if (root.val >= L && root.val <= R) {
            res[0] += root.val;
        }
        if (root.val >= L) {
            helper(root.left, L, R, res);
        }
        if (root.val <= R) {
            helper(root.right, L, R, res);
        }
        return res[0];
    }
}
