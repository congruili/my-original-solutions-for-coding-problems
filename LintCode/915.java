// 915. Inorder Predecessor in BST

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
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        
        if (root.val >= p.val) {
            return inorderPredecessor(root.left, p);
        } else {
            TreeNode right = inorderPredecessor(root.right, p);
            if (right == null) {
                return root;
            } else {
                return right;
            }
        }
        
    }
}