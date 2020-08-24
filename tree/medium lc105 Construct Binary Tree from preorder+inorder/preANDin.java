import java.util.*;
public class preANDin {
    public class TreeNode {
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
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

    }
    private TreeNode construct(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, HashMap<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inPivot = map.get(root.val);
        int len = inPivot - inLeft; // represents for the number of elements in the left subtree of current node
        root.left = construct(preorder, preLeft + 1, preLeft + len, inorder, inLeft, inPivot - 1, map);
        root.right = construct(preorder, preLeft + 1 + len, preRight, inorder, inPivot + 1, inRight, map);
        return root;
    }
}
