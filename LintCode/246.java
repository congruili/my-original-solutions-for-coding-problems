// 246. Binary Tree Path Sum II

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
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
     
    List<List<Integer>> rst; 
    
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        rst = new ArrayList<List<Integer>>();

        dfs(root, target, 0, new ArrayList<Integer>());
        
        return rst;
    }
    
    private void dfs(TreeNode root, int target, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        int sum = 0;
        
        list.add(root.val);
        for (int i = level; i >= 0; --i) {
            sum += list.get(i);
            if (sum == target) {
                List<Integer> curt = new ArrayList<>();
                for (int j = i; j <= level; ++j) {
                    curt.add(list.get(j));
                }
                rst.add(curt);
            }
        }
        
        dfs(root.left, target, level + 1, list);
        dfs(root.right, target, level + 1, list);
        
        list.remove(list.size() - 1);
    }
}