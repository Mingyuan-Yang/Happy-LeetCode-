import java.util.*;
public class levelOrderTraversal {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>>  levelOrder(TreeNode root) {
        /*
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
         */

         List<List<Integer>> res = new ArrayList<>();
         if (root == null) return res;
         helper(root, res, 0);
         return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (res.size() == level) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        if (root.left != null) helper(root.left, res, level + 1);
        if (root.right != null) helper(root.right, res, level + 1);
    }
}