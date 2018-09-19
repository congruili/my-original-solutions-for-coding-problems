// 597. Subtree with Maximum Average

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
 
class ResultType {
    int sum, count;
    public ResultType(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
} 

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    double maxAverage = Double.MIN_VALUE;
    TreeNode rstNode = null;
     
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return rstNode;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int newSum = root.val + left.sum + right.sum;
        int newCount = 1 + left.count + right.count;
        double newAverage = (double)newSum / newCount;
        
        if (rstNode == null || newAverage > maxAverage) {
            maxAverage = newAverage;
            rstNode = root;
        }
        
        return new ResultType(newSum, newCount);
    }
}