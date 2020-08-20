public class balanced {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        //System.out.println(leftH);
        //System.out.println(rightH);
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        balanced test = new balanced();
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;
        boolean res = test.isBalanced(root);
        System.out.print(res);
    }
}
