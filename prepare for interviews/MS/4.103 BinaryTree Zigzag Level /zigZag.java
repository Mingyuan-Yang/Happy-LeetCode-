import java.util.*;
public class zigZag {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (root == null) return res;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
            level++;
        }
        return res;
        */

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                list.add(root.val);
                if (root.left != null) stack2.push(root.left);
                if (root.right != null) stack2.push(root.right);
            }
            if (!list.isEmpty()) res.add(list);
            List<Integer> list2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                root = stack2.pop();
                list2.add(root.val);
                if (root.right != null) stack1.push(root.right);
                if (root.left != null) stack1.push(root.left);
            }
            if (!list2.isEmpty()) res.add(list2);
        }
        return res;
    }
}
