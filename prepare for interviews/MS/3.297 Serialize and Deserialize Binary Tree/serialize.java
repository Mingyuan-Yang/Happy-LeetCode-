import java.util.*;
public class serialize {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        String s = "";
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) s += "null";
            else {
                s += String.valueOf(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            s += ",";
        }
        return s;
    }
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] s = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        queue.offer(root);
        for (int i = 1; i < s.length; i++) {
            TreeNode node = queue.poll();
            if (!s[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(s[i]));
                node.left = left;
                queue.offer(left);
            }
            if (!s[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(s[i]));
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
