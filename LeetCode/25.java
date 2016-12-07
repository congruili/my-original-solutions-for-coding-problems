/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curt = head;
        while (curt != null) {
            len++;
            curt = curt.next;
        }
        
        if (k > len) return head;
        int n = len / k;
        curt = dummy;
        
        for (int i = 0; i < n; ++i) {
            int count = 0;
            ListNode preL = curt;
            curt = curt.next;
            ListNode left = curt;
            preL.next = null;
            ListNode pre = null;
            
            while (count < k) {
                ListNode tmp = curt.next;
                curt.next = pre;
                pre = curt;
                curt = tmp;
                count++;
            }
            
            preL.next = pre;
            left.next = curt;
            curt = left;
        }
        
        return dummy.next;
    }
}