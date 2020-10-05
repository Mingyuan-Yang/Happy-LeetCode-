import java.util.*;
public class validate {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isValidBST(TreeNode root) {

//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode pre = null;
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (pre != null && pre.val >= root.val) return false;
//            pre = root;
//            root = root.right;
//        }
//        return true;


        List<Integer> list = new ArrayList<>();
        helper(list, root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }
    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}
