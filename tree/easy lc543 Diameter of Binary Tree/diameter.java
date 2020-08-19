import java.util.*;
public class diameter {
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
//    recursion solution:
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    private int helper(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        diameter test = new diameter();
        TreeNode root = new TreeNode(1);
        System.out.println(root.val);
        root.left = new TreeNode(2);
        System.out.println(root.left.val);
        root.right = new TreeNode(3);
        System.out.println(root.right.val);
        root = root.left;
        System.out.println(root.val);
        root.left = new TreeNode(4);
        System.out.println(root.left.val);
        root.right = new TreeNode(5);
        System.out.println(root.right.val);
        int res = test.diameterOfBinaryTree(root);
        System.out.print(res);
    }
}
