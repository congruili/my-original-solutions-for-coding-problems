453. Flatten Binary Tree to Linked List

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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        
        root.right = right;
    }
}