/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int rst = 0;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) return rst;
        helper(root, 1);
        
        return rst;
    }
    
    public void helper(TreeNode root, int curt) {
        rst = Math.max(rst, curt);
        
        if (root.left != null) {
            if (root.left.val - root.val == 1) helper(root.left, curt + 1);
            else helper(root.left, 1);
        }
        
        if (root.right != null) {
            if (root.right.val - root.val == 1) helper(root.right, curt + 1);
            else helper(root.right, 1);
        }
    }
}