/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int rst = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger n: nestedList) queue.offer(n);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                NestedInteger curt = queue.poll();
                if (curt.isInteger()) rst += level * curt.getInteger();
                else queue.addAll(curt.getList());
            }
            level++;
        }
        
        return rst;
    }
}