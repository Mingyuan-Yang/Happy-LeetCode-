public class lca {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode (TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    TreeNode node;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return node;
    }
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        boolean center = false;
        if (root == p || root == q) center = true;
        if (left && right || left && center || right && center) {
            node = root;
        }
        return left || right || center;
    }
}
