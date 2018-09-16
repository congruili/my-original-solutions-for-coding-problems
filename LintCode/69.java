// 69. Binary Tree Level Order Traversal (dfs version)

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
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        
        int maxLevel = 0;
    
        while (true) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list, 0, maxLevel);
            if (list.size() == 0) {
                break;
            }
            
            rst.add(list);
            maxLevel++;
        }
        
        return rst;
    }
    
    private void dfs(TreeNode root, List<Integer> list, int level, int maxLevel) {
        if (root == null) {
            return;
        }
        
        if (level == maxLevel) {
            list.add(root.val);
            return;
        }
        
        dfs(root.left, list, level + 1, maxLevel);
        dfs(root.right, list, level + 1, maxLevel);
    }
}