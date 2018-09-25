// 1106. Maximum Binary Tree

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
     * @param nums: an array
     * @return: the maximum tree
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Write your code here
        if (nums == null) {
            return null;
        }
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        
        int maxVal = nums[begin];
        int ind = begin;
        for (int i = begin; i <= end; ++i) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                ind = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[ind]);
        root.left = helper(nums, begin, ind - 1);
        root.right = helper(nums, ind + 1, end);

        return root;
    }
}