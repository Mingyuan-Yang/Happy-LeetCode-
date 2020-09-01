public class leafnumbers {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int count;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        count = 0;
        helper(root, 0);
        return count;
    }
    private void helper(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            count += root.val + sum * 10;
        }
        helper(root.left, root.val + sum * 10);
        helper(root.right, root.val + sum * 10);
    }
    public static void main(String[] args) {
        leafnumbers test = new leafnumbers();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        int res = test.sumNumbers(root);
        System.out.println(res);
    }
}
