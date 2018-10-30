## 75 Sort Colors
<pre>
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;        
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, right, i);
                right--;
            }           
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
</pre>

## 148 Sort List
<pre>
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head, fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        
        return merge(first, second);     
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;            
        }
        
        if (b == null) {
            return a;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curt.next = a;
                a = a.next;            
            } else {
                curt.next = b;
                b = b.next;
            }
            
            curt = curt.next;
        }
        
        if (a != null) {         
            curt.next = a;
        }
        
        if (b != null) {
            curt.next = b;
        }
        
        return dummy.next;       
    }
}
</pre>

## 150 Evaluate Reverse Polish Notation
<pre>
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (String s: tokens) {
            if (isSymbol(s)) {
                int a = stack.pop();
                int b = stack.pop();
                
                if (s.equals("+")) {
                    stack.push(a + b);
                } else if (s.equals("-")) {
                    stack.push(b - a);
                } else if (s.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(b / a);
                }            
            } else {
                stack.push(Integer.parseInt(s));
            }        
        }
        
        return stack.pop(); 
    }
    
    private boolean isSymbol(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");  
    }
}
</pre>

## 152 Maximum Product Subarray
<pre>
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int rst = nums[0];
        int preMin = nums[0];
        int preMax = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            int curt = nums[i];
            int curtMin = Math.min(curt, Math.min(preMin * curt, preMax * curt));
            int curtMax = Math.max(curt, Math.max(preMin * curt, preMax * curt));   
            rst = Math.max(rst, curtMax);
            
            preMin = curtMin;
            preMax = curtMax;
        }
        
        return rst;       
    }
}
</pre>

## 160 Intersection of Two Linked Lists
<pre>
/**
 * Definition for singly-linked list.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB;
        
        while (a != null) {
            a = a.next;
            lenA ++;
        }
        
        while (b != null) {
            b = b.next;
            lenB ++;
        }
        
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;        
    }
}
</pre>

## 162 Find Peak Element
<pre>
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int begin = 0, end = nums.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid - 1] < nums[mid]) {
                begin = mid;
            } else {
                end = mid;
            }        
        }
        
        if (nums[begin] > nums[end]) {
            return begin;
        }
        
        return end;        
    }
}
</pre>

## 169 Majority Element
<pre>
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;
        for (int num: nums) {
            if (count == 0) {
                major = num;
            }
            
            if (num == major) {
                count ++;
            } else {
                count --;
            }       
        }
        
        return major;        
    }
}
</pre>

## 171 Excel Sheet Column Number
<pre>
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int rst = 0;
        char[] sc = s.toCharArray();
        int len = sc.length;
        int base = 1;
        
        for (int i = len - 1; i >= 0; --i) {
            int curt = sc[i] - 'A' + 1;
            rst += curt * base;
            base *= 26;       
        }
        
        return rst;        
    }
}
</pre>

## 172 Factorial Trailing Zeroes
<pre>
class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int rst = 0;
        
        while (n > 0) {
            rst += n / 5;
            n /= 5;           
        }
        
        return rst;        
    }
}
</pre>

## 179 Largest Number
<pre>
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        int len = nums.length;
        String[] strs = new String[len];
        
        for (int i = 0; i < len; ++i) {
            strs[i] = nums[i] + "";
        }
        
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);            
            }        
        };
        
        Arrays.sort(strs, comp);
        
        for (String s: strs) {
            sb.append(s);
        }
        
        while (sb.length() > 0) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);            
            } else {
                break;
            }        
        }
        
        if (sb.length() == 0) {
            return "0";
        }
        
        return sb.toString(); 
    }
}
</pre>

## 189 Rotate Array
<pre>
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int len = nums.length;
        k %= len;
        if (k == 0) {
            return;
        }
        
        swap(nums, 0, len - k - 1);
        swap(nums, len - k, len - 1);
        swap(nums, 0, len - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;        
        }    
    }
}
</pre>

## 190 Reverse Bits
<pre>
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rst = 0;
        for (int i = 0; i < 32; ++i) {
            rst = (rst << 1);
            rst += ((n >>> i) & 1);
        }
        
        return rst;        
    }
}
</pre>

## 191 Number of 1 Bits
<pre>
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n = (n & (n - 1));        
        }
        
        return count;        
    }
}
</pre>