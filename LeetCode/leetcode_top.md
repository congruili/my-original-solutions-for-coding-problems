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

## 198 House Robber
<pre>
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        
        int[] rst = new int[len + 1];
        rst[0] = 0, rst[1] = nums[0];
        
        for (int i = 2; i <= len; ++i) {
            rst[i] = Math.max(rst[i - 1], rst[i - 2] + nums[i - 1]);        
        }
        
        return rst[len];        
    }
}
</pre> 

## 200 Number of Islands
<pre>
class UnionFind {
    int size;
    int[] father;
    int count;
    
    public UnionFind(int size) {
        father = new int[size];
        
        for (int i = 0; i < size; ++i) {
            father[i] = i;
        }    
    }
    
    public void set_count(int count) {
        this.count = count;
    }
    
    public int find(int x) {
        List<Integer> list = new ArrayList<>();
        
        while (father[x] != x) {
            list.add(x);
            x = father[x];            
        }
        
        for (int i: list) {
            father[i] = x;
        }    
        
        return x;
    }
    
    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            count --;
            father[root_a] = root_b;
        }
    }
    
    public int query() {
        return count;
    }

}


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
        
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    count ++;
                }            
            }        
        }
        
        uf.set_count(count);
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '0') {
                    continue;
                }
                
                for (int k = 0; k < 4; ++k) {
                    int new_x = i + dx[k];
                    int new_y = j + dy[k];
                    
                    if (isValid(grid, new_x, new_y) && grid[new_x][new_y] == '1' && uf.find(new_x * m + new_y) != i * m + j) {
                        uf.union(new_x * m + new_y, i * m + j);                    
                    }               
                }
            }        
        }
        
        return uf.query();        
    }
    
    private boolean isValid(char[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        return i >= 0 && i < n && j >= 0 && j < m;      
    }
}
</pre>  

## 202 Happy Number
<pre>
class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        
        while (true) {
            int curt = 0;
            while (n != 0) {
                int i = n % 10;
                curt += i * i;
                n /= 10;            
            }
            
            if (curt == 1) {
                return true;
            }            
            
            if (set.contains(curt)) {
                break;
            }
            
            set.add(curt);            
            n = curt;        
        }
        
        return false;        
    }
}
</pre> 

## 204 Count Primes
<pre>
class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        
        boolean[] notPrime = new boolean[n];
        int rst = 0;
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                rst ++;
                for (int j = 2; j * i < n; ++j) {
                    notPrime[i * j] = true;                
                }
            }        
        }
        
        return rst;       
    }
}
</pre>

## 230 Kth Smallest Element in a BST
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
    public int kthSmallest(TreeNode root, int k) {
        int left = numOfNodes(root.left);
        if (left == k - 1) {
            return root.val;
        } else if (left >= k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }
    
    private int numOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return numOfNodes(root.left) + numOfNodes(root.right) + 1;    
    }
}
</pre>

## 234 Palindrome Linked List (O(n) time and O(1) space)
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);
        
        while (second != null) {
            if (head.val != second.val) {
                return false;
            }
            
            head = head.next;
            second = second.next;
        }
        
        return true;               
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;        
        }
        
        return pre;    
    }
}
</pre>

## 236 Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        if (left == null) {
            return right;
        }
        
        return left;        
    }
}
</pre>

## 238 Product of Array Except Self
<pre>
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        
        int len = nums.length;
        
        int[] rst = new int[len];
        rst[0] = nums[0];
        
        for (int i = 1; i < len; ++i) {
            rst[i] = rst[i - 1] * nums[i];
        }
        
        rst[len - 1] = rst[len - 2];
        int curt = nums[len - 1];
        
        for (int i = len - 2; i > 0; --i) {
            rst[i] = rst[i - 1] * curt;
            curt = curt * nums[i];
        }
        
        rst[0] = curt;
        
        return rst;   
    }
}
</pre>

## 239 Sliding Window Maximum
<pre>
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        
        int len = nums.length;
        
        int[] rst = new int[len - k + 1];
    
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < k; ++i) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            } 
            
            q.offer(i);
        }
        
        rst[0] = nums[q.peekFirst()];
        
        for (int i = k; i < len; ++i) {
            while (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            } 
            
            q.offer(i);
            
            rst[i - k + 1] = nums[q.peekFirst()];
        }
        
        return rst;  
    }
}
</pre>

## 240 Search a 2D Matrix II
<pre>
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int n = matrix.length, m = matrix[0].length;
        
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row ++;
            } else {
                col --;
            }       
        }
        
        return false;        
    }
}
</pre>

## 253 Meeting Rooms II
<pre>
class Point {
    int flag;
    int time;
    public Point(int flag, int time) {
        this.flag = flag;
        this.time = time;    
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time != b.time) {
                    return a.time - b.time;
                }
                
                return a.flag - b.flag;            
            }        
        };
        
        List<Point> times = new ArrayList<>();
        
        for (Interval i: intervals) {
            times.add(new Point(1, i.start));
            times.add(new Point(0, i.end));
        }
        
        Collections.sort(times, comp);        
        
        int count = 0;
        int rst = 0;
        
        for (Point t: times) {
            if (t.flag == 1) {
                count ++;
            } else {
                count --;
            }
            
            rst = Math.max(rst, count);
        }
        
        return rst;                
    }
}
</pre>

## 268 Missing Number
<pre>
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {  
            while (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);            
            }        
        }
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return n;        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;   
    }
}
</pre>

## 269 Alien Dictionary
<pre>
class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        
        int len = words.length;
        
        for (String w: words) {
            for (char c: w.toCharArray()) {
                degree.put(c, 0);
            }        
        }
        
        for (int i = 0; i < len - 1; ++i) {
            String one = words[i];
            String two = words[i + 1];
            
            int limit = Math.min(one.length(), two.length());
            
            for (int j = 0; j < limit; ++j) {
                char c1 = one.charAt(j);
                char c2 = two.charAt(j); 
            
                if (c1 != c2) {
                    if (!map.containsKey(c1)) {
                        map.put(c1, new HashSet<Character>());                    
                    }
                    
                    map.get(c1).add(c2);  
                    break;
                }
            }        
        }
        
        for (char c: map.keySet()) {
            for (char next: map.get(c)) {
                degree.put(next, degree.get(next) + 1);            
            }        
        }
        
        StringBuilder sb = new StringBuilder();
        
        Queue<Character> q = new LinkedList<>();
        for (char c: degree.keySet()) {
            if (degree.get(c) == 0) {
                q.offer(c);
            }        
        }
        
        while (!q.isEmpty()) {
            char curt = q.poll();
            sb.append(curt);
            if (!map.containsKey(curt)) {
                continue;
            }
            
            for (char next: map.get(curt)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) {
                    q.offer(next);
                }            
            }        
        }
        
        if (degree.size() == sb.length()) {
            return sb.toString();
        }
        
        return "";   
    }
}
</pre>

## 277 Find the Celebrity
<pre>
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;
        for (int i = 1; i < n; ++i) {
            if (!knows(i, cand)) {
                cand = i;
            }        
        }
        
        for (int i = 0; i < n; ++i) {
            if (i == cand) {
                continue;
            }
            
            if (knows(cand, i) || !knows(i, cand)) {
                return -1;
            }        
        }
        
        return cand;        
    }
}
</pre>

## 279 Perfect Squares
<pre>
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int curt = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                curt = Math.min(curt, dp[i - j * j] + 1);
                j ++;
            }
            
            dp[i] = curt;        
        }
        
        return dp[n];        
    }
}
</pre>

## 285 Inorder Successor in BST (non-recursion)
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }        
        }
        
        return succ;        
    }
}
</pre>

## 285 Inorder Successor in BST (recursion)
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        
        TreeNode left = inorderSuccessor(root.left, p);
        if (left == null) {
            return root;
        }
        
        return left;        
    }
}
</pre>

