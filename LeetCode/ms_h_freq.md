## 402. Remove K Digits
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

## 165. Compare Version Numbers
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

## 24. Swap Nodes in Pairs
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

## 229. Majority Element II
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

## 10. Regular Expression Matching
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

## 25. Reverse Nodes in k-Group
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

## 669. Trim a Binary Search Tree
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

## 443. String Compression
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

## 722. Remove Comments
<pre>
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> rst = new ArrayList<>();
        
        if (source == null || source.length == 0) {
            return rst;
        }
        
        boolean begin = false;
        StringBuilder sb = new StringBuilder();
        
        for (String s: source) {
            int len = s.length();
            for (int i = 0; i < len; ++i) {
                if (begin) {
                    if (s.charAt(i) == '*' && i < len - 1 && s.charAt(i + 1) == '/') {
                        begin = false;
                        i ++;                    
                    }               
                } else {
                    if (s.charAt(i) == '/' && i < len - 1 && s.charAt(i + 1) == '/') {
                        break;
                    } else if (s.charAt(i) == '/' && i < len - 1 && s.charAt(i + 1) == '*') {
                        begin = true;
                        i ++;
                    } else {
                        sb.append(s.charAt(i));                    
                    }            
                }
                

            }
            
            if (!begin && sb.length() > 0) {
                rst.add(sb.toString());
                sb = new StringBuilder();               
            }        
        }
        
        return rst;        
    }
}
</pre>

## 545. Boundary of Binary Tree
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
    List<Integer> list;    

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        list.add(root.val);        
        goLeft(root.left);
        getLeaves(root.left);
        getLeaves(root.right);
        goRight(root.right);
        
        return list;       
    }
    
    private void goLeft(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        
        list.add(node.val);
        if (node.left != null) {
            goLeft(node.left);
        } else {
            goLeft(node.right);
        }   
    }
    
    private void getLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        } 
        
        if (node.left != null) {
            getLeaves(node.left);        
        }
        
        if (node.right != null) {
            getLeaves(node.right);        
        }
    }
    
    private void goRight(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        
        if (node.right != null) {
            goRight(node.right);
        } else {
            goRight(node.left);
        }
        
        list.add(node.val);    
    
    }
}
</pre>

## 558. Quad Tree Intersection
<pre>
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {       
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;        
        }
        
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;        
        }
        
        Node rst = new Node();
        Node topLeft =  intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight =  intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft =  intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight =  intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
                rst.val = true;
                rst.isLeaf = true;
                return rst;            
            } else if (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val) {
                rst.val = false;
                rst.isLeaf = true;
                return rst;            
            } 
        }
        
        rst.topLeft = topLeft;
        rst.topRight = topRight;
        rst.bottomLeft = bottomLeft;
        rst.bottomRight = bottomRight;
        
        rst.isLeaf = false;
        return rst;
        
    }
}
</pre>

## 450. Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);              
            }        
        }
        
        return root;        
    }
    
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        
        return node;    
    }
}
</pre>

## 398. Random Pick Index
<pre>
class Solution {
    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();       
    }
    
    public int pick(int target) {
        int cand = -1;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != target) {
                continue;
            }
            
            count ++;
            if (rand.nextInt(count) == 0) {
                cand = i;
            }        
        }
        
        return cand;       
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
</pre>

## 836. Rectangle Overlap
<pre>
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) {
            return false;
        }
        
        return true;       
    }
}
</pre>

## 61. Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
    
        int len = 0;
        ListNode curt = head;
        while (curt != null) {
            len ++;
            curt = curt.next;
        }
        
        k %= len;
        
        if (k == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        while (k > 0) {
            fast = fast.next;
            k --;
        }
        
        ListNode slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;        
        
    }
}
</pre>

## 138. Copy List with Random Pointer
<pre>
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        copyNext(head);
        copyRandom(head);
        
        return split(head);        
    }
    
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }    
    }
    
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;            
            }
            
            head = head.next.next;       
        }
    }
    
    private RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        
        while (head != null) {
            RandomListNode tmp = head.next;
            head.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
            
            head = head.next;           

        }
        
        return newHead; 
    
    }
}
</pre>

