// 167. Add Two Numbers

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null) {
            int ans1 = l1 == null ? 0 : l1.val;
            int ans2 = l2 == null ? 0 : l2.val;
            int sum = ans1 + ans2 + carry;
            curt.next = new ListNode(sum % 10);
            curt = curt.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum / 10;
        }
        
        if (carry != 0) {
            curt.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}