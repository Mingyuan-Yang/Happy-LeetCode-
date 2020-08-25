import java.util.*;
public class leavesofBT {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int level = Math.max(left, right) + 1;
        System.out.println(level);
        if (level == res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        return level;
    }
    public static void main(String[] args) {
        leavesofBT test = new leavesofBT();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        res = test.findLeaves(root);
        System.out.print(res);
    }
}
