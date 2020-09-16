public class robber3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int rob (TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  // not select current node
        res[1] = root.val + left[0] + right[0];
        return res;
    }
    public static void main(String[] args) {
        robber3 test = new robber3();
        TreeNode root = new TreeNode (3);
        TreeNode root1 = new TreeNode (2);
        TreeNode root2 = new TreeNode (3);
        TreeNode root3 = new TreeNode (3);
        TreeNode root4 = new TreeNode (1);
        root.left = root1;
        root.right = root2;
        root1.right = root3;
        root2.right = root4;
        int res = test.rob(root);
        System.out.print(res);
    }
}
