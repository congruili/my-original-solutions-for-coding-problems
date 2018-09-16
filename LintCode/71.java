// 71. Binary Tree Zigzag Level Order Traversal

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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<>();
        
        if (root == null) {
            return rst;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false; 
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode curt = q.poll();
                list.add(curt.val);
                if (curt.left != null) {
                    q.offer(curt.left);
                }
                
                if (curt.right != null) {
                    q.offer(curt.right);
                }
            }
            
            if (reverse) {
                Collections.reverse(list);
                reverse = false;
            } else {
                reverse = true;
            }
            
            rst.add(list);
        }
        
        return rst;
    }
}