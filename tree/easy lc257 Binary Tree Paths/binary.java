import java.util.*;
public class binary {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<String>  binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        return helper(root, res, "");

    }
    private List<String> helper(TreeNode root, List<String> res, String s) {
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            s += root.val;
            res.add(s);
        }
        helper(root.left, res, s + root.val + "->");
        helper(root.right, res, s + root.val + "->");
        return res;
    }
    public static void main(String[] args) {
        binary test = new binary();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        List<String> res = test.binaryTreePaths(root);
        System.out.print(res);
    }
}
