import java.util.*;

public class main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int x;
        TreeNode(int x) { val = x; }
    }
    public static int find1(TreeNode root, double target) {
        if(root.val == target) {
            return root.val;
        }
        int val = root.val;
        while(root != null) {
            if (Math.abs(val - target) > Math.abs(root.val - target)) {
                val = root.val;
                if (Math.abs(val - target) <= 0.5) {
                    return val;
                }
            }
            if (root.val > target) root = root.left;
            if (root.val < target) root = root.right;
        }
        return val;
    }
    public static void main(String[] args) {
        main s = new main();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        double target = 3.714286;
        int result = s.find1(root, target);
        System.out.println(result);
    }
}

//   4
//  2  5
// 1 3  7
