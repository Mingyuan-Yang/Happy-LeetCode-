import java.util.*;
public class two {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        System.out.print(list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = list.get(left) + list.get(right);
            if (mid == k) return true;
            else if (mid < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
    public static void main(String[] args) {
        two test = new two();
        int k = 9;
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        boolean res = test.findTarget(root, k);
        System.out.print(res);
    }
}
