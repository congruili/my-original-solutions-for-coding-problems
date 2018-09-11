/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode curt = head;
        
        while (curt != null) {
            map.put(curt, new RandomListNode(curt.label));
            curt = curt.next;
        }
        
        curt = head;
        
        while (curt != null) {
            map.get(curt).next = map.get(curt.next);
            map.get(curt).random = map.get(curt.random);
            curt = curt.next;
        }
        
        return map.get(head);
    }
}