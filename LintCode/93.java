// 93. Balanced Binary Tree

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
     * @return: True if this Binary tree is Balanced, or false.
     */
    int NOT_BAL = -1;
    
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root) != NOT_BAL;
    }
    
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == NOT_BAL || right == NOT_BAL) {
            return NOT_BAL;
        }
        
        if (Math.abs(left - right) > 1) {
            return NOT_BAL;
        }
        
        return 1 + Math.max(left, right);
    }
}