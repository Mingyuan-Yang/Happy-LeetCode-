import java.util.*;
public class delete {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> res = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i : to_delete) set.add(i);
            helper(root, set, res);
            if (!set.contains(root.val)) res.add(0, root);
            return res;
        }
        private TreeNode helper(TreeNode root, HashSet<Integer> set, List<TreeNode> res) {
            if (root == null) return null;
            root.left = helper(root.left, set, res);
            root.right = helper(root.right, set, res);
            if (set.contains(root.val)) {
                if (root.left != null) res.add(root.left);
                if (root.right != null) res.add(root.right);
                return null;
            }
            return root;
        }
        public static void main(String[] args) {
            delete test1 = new delete();
            int[] to_delete = new int[]{3,5};
            TreeNode root = new TreeNode(1);
            TreeNode node1 = new TreeNode(2);
            TreeNode node2 = new TreeNode(3);
            TreeNode node3 = new TreeNode(4);
            TreeNode node4 = new TreeNode(5);
            TreeNode node5 = new TreeNode(6);
            TreeNode node6 = new TreeNode(7);
            root.left = node1;
            root.right = node2;
            node1.left = node3;
            node1.right = node4;
            node3.left = node5;
            node3.right = node6;
            List<TreeNode> res = test1.delNodes(root, to_delete);
        }
}
