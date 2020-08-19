public class convert {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(0, n-1, nums);
    }
    private TreeNode helper(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }
//    public static void main(String[] args) {
//        convert test = new convert();
//        int[] nums = new int[] {-10, -3, 0, 5, 9};
//        TreeNode root = test.sortedArrayToBST(nums);
//        System.out.print(root);
//    }
}
