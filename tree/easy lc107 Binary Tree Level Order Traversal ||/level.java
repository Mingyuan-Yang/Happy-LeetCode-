import java.util.*;
public class level {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        Collections.reverse(res);
        return res;
    }
    private List<List<Integer>> helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return res;
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        if (root.left != null) helper(root.left, res, level + 1);
        if (root.right != null) helper(root.right, res, level + 1);
        return res;
    }
    public static void main(String[] args) {
        level test = new level();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> res = test.levelOrderBottom(root);
        System.out.print(res);
    }
}
