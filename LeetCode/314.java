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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) return rst;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        nodes.offer(root);
        levels.offer(0);
        int min = 0, max = 0;
        
        while (!nodes.isEmpty()) {
            TreeNode curt = nodes.poll();
            int level = levels.poll();
            min = Math.min(min, level);
            max = Math.max(max, level);
            if (!map.containsKey(level)) map.put(level, new ArrayList<Integer>());
            map.get(level).add(curt.val);
            
            if (curt.left != null) {
                nodes.offer(curt.left);
                levels.offer(level - 1);
            }
            
            if (curt.right != null) {
                nodes.offer(curt.right);
                levels.offer(level + 1);
            }
        }
        
        for (int i = min; i <= max; ++i) rst.add(map.get(i));
        
        return rst;
    }
}