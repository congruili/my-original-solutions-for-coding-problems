// 86. Binary Search Tree Iterator

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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    Stack<TreeNode> stack;
    TreeNode curt;
    
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        stack = new Stack<>();
        curt = root;
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return (curt != null || !stack.isEmpty());
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        TreeNode rst = stack.pop();
        curt = rst.right;
        return rst;
    }
}