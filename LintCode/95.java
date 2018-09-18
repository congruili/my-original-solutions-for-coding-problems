// 95. Validate Binary Search Tree

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, Long lower, Long upper) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        
        return helper(root.left, lower, (long)root.val) && helper(root.right, (long)root.val, upper);
    }
}