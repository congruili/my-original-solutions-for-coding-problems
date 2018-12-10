[https://zhengyang2015.gitbooks.io/lintcode/](https://zhengyang2015.gitbooks.io/lintcode/)

## 164. Unique Binary Search Trees II
<pre>
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
     * @paramn n: An integer
     * @return: A list of root
     */
    Map<Integer, List<TreeNode>> map; 
     
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return helper(1, n);      
    }
    
    private List<TreeNode> helper(int begin, int end) {
        List<TreeNode> list = new ArrayList<>(); 
        
        if (begin > end) {
            list.add(null);
            return list;
        } 
        
        for (int i = begin; i <= end; ++i) {
            List<TreeNode> leftRoots = helper(begin, i - 1);
            List<TreeNode> rightRoots = helper(i + 1, end);
            for (TreeNode left: leftRoots) {
                for (TreeNode right: rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);                
                }     
            }       
        }
        
        return list;    
    
    }
}
</pre>


