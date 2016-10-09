public class Solution {
    public TreeNode trimBST(TreeNode root, int minVal, int maxVal) {
        if (root == null) return null;
        root.left = trimBST(root.left, minVal, maxVal);
        root.right = trimBST(root.right, minVal, maxVal);
        if (root.val < minVal) return root.right;
        if (root.val > maxVal) return root.left;
        return root;
    }
}