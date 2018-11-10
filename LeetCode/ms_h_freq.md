## 402 Remove K Digits
<pre>
class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0) {
            return num;
        }
        
        if (k >= num.length()) {
            return "0";
        }
        
        int i = 0;
        Stack<Character> stack = new Stack<>();
        
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();   
                k --;
            }
            
            stack.push(num.charAt(i));
            i ++;        
        }
        
        while (k > 0) {
            stack.pop();
            k --;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());        
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();      
        
    }
}
</pre>

## 165 Compare Version Numbers
<pre>
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        
        int len1 = strs1.length, len2 = strs2.length;
        int len = Math.max(len1, len2);
        int i = 0;
        
        while (i < len) {
            int one = i < len1 ? Integer.parseInt(strs1[i]) : 0;
            int two = i < len2 ? Integer.parseInt(strs2[i]) : 0;
            
            if (one < two) {
                return -1;
            }
            
            if (one > two) {
                return 1;
            }
            
            i ++;
        }
        
        return 0;             
    }
}
</pre>

## 24 Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);        
        dummy.next = head;
        ListNode curt = dummy;       
        
        while (curt.next != null && curt.next.next != null) {
            ListNode one = curt.next;
            ListNode two = curt.next.next;
            ListNode three = curt.next.next.next;
            curt.next = two;
            two.next = one;
            one.next = three;
            curt = one;      
        }
        
        return dummy.next;
        
    }
}
</pre>

## 229 Majority Element II
<pre>
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        
        if (nums.length < 2) {
            for (int i: nums) {
                rst.add(i);
            }
            
            return rst;        
        }
        
        int len = nums.length;
        
        int cand1 = nums[0];
        int cand2 = 0;
        int count1 = 1;
        int count2 = 0;
        
        for (int i = 1; i < len; ++i) {
            int x = nums[i];
            if (x == cand1) {
                count1 ++;
            } else if (x == cand2) {
                count2 ++;
            } else if (count1 == 0) {
                cand1 = x;
                count1 ++;            
            } else if (count2 == 0) {
                cand2 = x;
                count2 ++;
            } else {
                count1 --;
                count2 --;            
            }        
        }
        
        count1 = 0;
        count2 = 0;
        for (int i: nums) {
            if (i == cand1) {
                count1 ++;
            }
            
            if (i == cand2) {
                count2 ++;
            }
        }
        
        if (count1 > len / 3) {
            rst.add(cand1);
        }
        
        if (count2 > len / 3 && cand2 != cand1) {
            rst.add(cand2);
        }
        
        return rst;        

    }
}
</pre>

## 10 Regular Expression Matching
<pre>
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] visited = new boolean[lenS][lenP];
        boolean[][] valid = new boolean[lenS][lenP];
        
        return helper(s, p, 0, 0, visited, valid);       
    }
    
    private boolean helper(String s, String p, int indS, int indP, boolean[][] visited, boolean[][] valid) {
        if (indP == p.length()) {
            return indS == s.length();        
        }
        
        if (indS == s.length()) {
            return allStars(p, indP);      
        }
        
        if (visited[indS][indP]) {
            return valid[indS][indP];
        }
        
        boolean match;        
        
        if (indP + 1 < p.length() && p.charAt(indP + 1) == '*') {
            match = (charMatch(s.charAt(indS), p.charAt(indP)) && helper(s, p, indS + 1, indP, visited, valid)) || helper(s, p, indS, indP + 2, visited, valid);       
        } else {
            match = (charMatch(s.charAt(indS), p.charAt(indP)) && helper(s, p, indS + 1, indP + 1, visited, valid));   
        }
        
        visited[indS][indP] = true;
        valid[indS][indP] = match;
        return match;    
    }
    
    private boolean charMatch(char s, char p) {
        return s == p || p == '.';    
    }
    
    private boolean allStars(String p, int indP) {
        for (int i = indP; i < p.length(); i += 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }       
        }
        
        return true;  
    }
}
</pre>

## 25 Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;        
        }
        
        int i = 0;
        
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy;
        
        dummy.next = head;
        while (head != null) {
            i ++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;           
            } else {
                head = head.next;
            }       
        }
        
        return dummy.next;    
        
    }
    
    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode first = begin.next;
        ListNode curt = first;
        ListNode pre = begin;
        
        while (curt != end) {
            ListNode tmp = curt.next;
            curt.next = pre;
            pre = curt;
            curt = tmp;       
        }
        
        begin.next = pre;
        first.next = curt;
        
        return first;    

    }    
}
</pre>

## 669 Trim a Binary Search Tree
<pre>
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
        
    }
}
</pre>

## 443 String Compression
<pre>
class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        
        int count = 1;
        char curt = chars[0];
        int ind = 0;
        
        for (int i = 1; i < chars.length; ++i) {
            char c = chars[i];
            if (c == curt) {
                count ++;
                continue;
            }
            
            chars[ind ++] = curt;
            
            if (count > 1) {
                char[] sc = Integer.toString(count).toCharArray();
                for (int j = 0; j < sc.length; ++j) {
                    chars[ind + j] = sc[j];
                }
                
                ind += sc.length;
            }
            
            curt = chars[i];
            count = 1;        
        }
        
        chars[ind ++] = curt;        
        if (count > 1) {
            char[] sc = Integer.toString(count).toCharArray();
            for (int j = 0; j < sc.length; ++j) {
                chars[ind + j] = sc[j];
            }
            
            ind += sc.length;
        }
        
        return ind;        
        
    }
}
</pre>

