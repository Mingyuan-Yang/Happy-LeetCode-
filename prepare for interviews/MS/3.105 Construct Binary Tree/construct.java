import java.util.*;
public class construct {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    public TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight,
                           HashMap<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inPivot = map.get(root.val);
        int leftSize = inPivot - inLeft;
        root.left = helper(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, inPivot - 1, map);
        root.right = helper(preorder, preLeft + 1 + leftSize, preRight, inorder, inPivot + 1, inRight, map);
        return root;
    }
}
