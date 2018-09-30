// 651. Binary Tree Vertical Order Traversal

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
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        
        q.offer(root);
        levelQ.offer(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        
        while(!q.isEmpty()) {
            TreeNode curt = q.poll();
            int level = levelQ.poll();
            
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
            
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<Integer>());
            }
            
            map.get(level).add(curt.val);
            
            if (curt.left != null) {
                q.offer(curt.left);
                levelQ.offer(level - 1);
            }
            
            if (curt.right != null) {
                q.offer(curt.right);
                levelQ.offer(level + 1);
            }
        }
        
        for (int i = minLevel; i <= maxLevel; ++i) {
            rst.add(map.get(i));
        }
        
        return rst;
    }
}