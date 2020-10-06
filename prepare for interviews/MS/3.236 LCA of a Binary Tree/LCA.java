public class LCA {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return node;
    }
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (node != null) return false;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        boolean parent = false;
        if (root == p || root == q) parent = true;
        if (left && right || left && parent || right && parent) {
            node = root;
        }
        return left || parent || right;
    }
}
