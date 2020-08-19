public class invert {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
