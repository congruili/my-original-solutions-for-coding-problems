// 900. Closest Binary Search Tree Value

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
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        double diff = Math.abs(root.val - target);
        int rst = root.val;
        
        TreeNode curt = root;
        
        while (curt != null) {
            if (Math.abs(curt.val - target) == 0) {
                return curt.val;
            }
            
            if (Math.abs(curt.val - target) < diff) {
                diff = Math.abs(curt.val - target);
                rst = curt.val;
            }
            
            if (curt.val < target) {
                curt = curt.right;
            } else {
                curt = curt.left;
            }
        }
        
        return rst;
    }
    
}