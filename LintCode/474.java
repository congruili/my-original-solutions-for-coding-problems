// 474. Lowest Common Ancestor II

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        
        int lenA = 0;
        ParentTreeNode a = A;
        while (a != null) {
            a = a.parent;
            lenA++;
        }
        
        int lenB = 0;
        ParentTreeNode b = B;
        while (b != null) {
            b = b.parent;
            lenB++;
        }
        
        while (lenA > lenB) {
            A = A.parent;
            lenA--;
        }
        
        while (lenB > lenA) {
            B = B.parent;
            lenB--;
        }
        
        // null == null
        while (A != B) {
            A = A.parent;
            B = B.parent;
            lenA--;
            lenB--;
        }
        
        return A;
    }
}