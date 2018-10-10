// 104. Merge K Sorted Lists

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        return helper(lists, 0, lists.size() - 1);        
    }
    
    private ListNode helper(List<ListNode> lists, int begin, int end) {
        if (begin == end) {
            return lists.get(begin);
        }    
    
        int mid = begin + (end - begin) / 2;
        
        ListNode first = helper(lists, begin, mid);
        ListNode second = helper(lists, mid + 1, end);
        return mergeTwo(first, second);  
    }
    
    private ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        
        if (b == null) {
            return a;
        }
    
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;        
    }
}
