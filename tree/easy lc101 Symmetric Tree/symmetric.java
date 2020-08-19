import java.util.*;
public class symmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//    private boolean isMirror(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) return true;
//        if (root1 == null || root2 == null) return false;
//        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
//    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.poll();
            TreeNode curr2 = queue.poll();
            if (curr1 == null && curr2 == null) continue;
            if (curr1 == null || curr2 == null) return false;
            if (curr1.val != curr2.val) return false;
            queue.offer(curr1.left);
            queue.offer(curr2.right);
            queue.offer(curr1.right);
            queue.offer(curr2.left);
        }
        return true;
    }
}
