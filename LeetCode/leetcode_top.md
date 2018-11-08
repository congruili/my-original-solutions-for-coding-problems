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

## 287 Find the Duplicate Number
<pre>
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int begin = 1, end = n;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            
            if (count(nums, mid) > mid) {
                end = mid;
            } else {
                begin = mid;
            }       
        }
        
        if (count(nums, begin) > begin) {
            return begin;
        }
        
        return end;        
    }
    
    private int count(int[] nums, int cand) {
        int rst = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= cand) {
                rst ++;
            }
        }
        
        return rst;    
    }
}
</pre>

## 289 Game of Life
<pre>
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int n = board.length, m = board[0].length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int count = countLive(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }               
                } else {
                    if (count == 3) {
                        board[i][j] += 2;
                    }                
                }
            }       
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] = (board[i][j] >> 1);
            }       
        }
    
        
    }
    
    private int countLive(int[][] board, int row, int col) {
        int n = board.length, m = board[0].length;
        int count = 0;
        
        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, n - 1); ++i) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, m - 1); ++j) {
                if (i == row && j == col) {
                    continue;
                }
                
                if ((board[i][j] & 1) == 1) {
                    count ++;
                }            
            }        
        } 
        
        return count;    
    }
}
</pre>

## 295 Find Median from Data Stream
<pre>
class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> one;    
    Queue<Integer> two;    
    
    public MedianFinder() {
        one = new PriorityQueue<>(Collections.reverseOrder());
        two = new PriorityQueue<>();         
    }
    
    public void addNum(int num) {
        one.offer(num);
        two.offer(one.poll());
        
        if (two.size() > one.size()) {
            one.offer(two.poll());
        }       
    }
    
    public double findMedian() {
        if (one.size() > two.size()) {
            return (double)(one.peek());
        }
        
        return (one.peek() + two.peek()) / 2.0;       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
</pre>

## 297 Serialize and Deserialize Binary Tree
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curt = q.poll();
                if (curt != null) {
                    sb.append(curt.val).append(',');
                    q.offer(curt.left);
                    q.offer(curt.right);                
                } else {
                    sb.append("#,");
                }            
            }        
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        
        int ind = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[ind ++]));
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curt = q.poll();
                if (strs[ind].equals("#")) {
                    curt.left = null;                    
                } else {
                    curt.left = new TreeNode(Integer.parseInt(strs[ind]));
                    q.offer(curt.left);                
                }                
                ind ++;
                
                if (strs[ind].equals("#")) {
                    curt.right = null;                    
                } else {
                    curt.right = new TreeNode(Integer.parseInt(strs[ind]));
                    q.offer(curt.right);                
                }                
                ind ++;
            }        
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
</pre>

## 322 Coin Change
<pre>
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; ++i) {
            dp[i] = -1;
            for (int j = 0; j < n; ++j) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }                                    
                }           
            }        
        }
        
        return dp[amount];        
    }
}
</pre>

## 329 Longest Increasing Path in a Matrix
<pre>
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int n = matrix.length, m = matrix[0].length;
        
        int[][] rst = new int[n][m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (rst[i][j] == 0) {
                    dfs(rst, i, j, matrix);                   
                }            
            }       
        }
        
        int maxLen = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                maxLen = Math.max(maxLen, rst[i][j]);
            }        
        }
        
        return maxLen;
    }
    
    private void dfs(int[][] rst, int i, int j, int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if (!isValid(rst, i, j)) {
            return;
        }
        
        if (rst[i][j] > 0) {
            return;
        }
        
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        
        rst[i][j] = 1;
        
        for (int k = 0; k < 4; ++k) {
            int new_i = di[k] + i;
            int new_j = dj[k] + j;
            
            if (!isValid(rst, new_i, new_j)) {
                continue;
            }
            
            if (matrix[new_i][new_j] < matrix[i][j]) {
                if (rst[new_i][new_j] == 0) {
                    dfs(rst, new_i, new_j, matrix);
                }               
                
                rst[i][j] = Math.max(rst[i][j], rst[new_i][new_j] + 1);            
            }       
        }
    }
    
    private boolean isValid(int[][] rst, int i, int j) {
        int n = rst.length, m = rst[0].length;
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
</pre>

## 340 Longest Substring with At Most K Distinct Characters
<pre>
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int[] hash = new int[256];
        char[] sc = s.toCharArray();
        int count = 0;
        int left = 0;
        
        for (int i = 0; i < sc.length; ++i) {
            char c = sc[i];
            hash[c] ++;
            if (hash[c] == 1) {
                count ++;
            }
            
            while (count > k) {
                char d = sc[left];
                hash[d] --;
                if (hash[d] == 0) {
                    count --;
                }
                left ++;            
            }
            
            maxLen = Math.max(maxLen, i - left + 1);        
        }
        
        return maxLen;      
    }
}
</pre>

## 341 Flatten Nested List Iterator
<pre>
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
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            stack.push(nestedList.get(i));        
        }        
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        
        return stack.pop().getInteger();      
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            
            for (int i = list.size() - 1; i >= 0; --i) {
                stack.push(list.get(i));            
            }        
        }
        
        return !stack.isEmpty();        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
</pre>

## 348 Design Tic-Tac-Toe
<pre>
class TicTacToe {

    /** Initialize your data structure here. */
    int[] rows;
    int[] cols;
    int diag;
    int anti_diag;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        anti_diag = 0;        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int n = rows.length;
        int add = 1;
        if (player == 2) {
            add = -1;
        }
        
        rows[row] += add;
        cols[col] += add;
        
        if (row == col) {
            diag += add;        
        }
        
        if (row + col == n - 1) {
            anti_diag += add;
        }
        
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(anti_diag) == n) {
            return player;
        }
        
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
</pre>

## 378 Kth Smallest Element in a Sorted Matrix
<pre>
class Point {
    int val, row, col;
    public Point(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;    
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        
        boolean[][] used = new boolean[n][m];
        
        Point p = new Point(matrix[0][0], 0, 0);
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return a.val - b.val;            
            }        
        };
        
        Queue<Point> q = new PriorityQueue<>(k, comp);
        q.offer(p);
        used[p.row][p.col] = true;
        int count = 1;
        
        while(count < k) {
            Point curt = q.poll();
            if (curt.row + 1 < n && !used[curt.row + 1][curt.col]) {
                q.offer(new Point(matrix[curt.row + 1][curt.col], curt.row + 1, curt.col));
                used[curt.row + 1][curt.col] = true;
            }
            
            if (curt.col + 1 < m && !used[curt.row][curt.col + 1]) {
                q.offer(new Point(matrix[curt.row][curt.col + 1], curt.row, curt.col + 1));
                used[curt.row][curt.col + 1] = true;
            }
            
            count ++;       
        }
        
        return q.peek().val;       
    }
}
</pre>

## 380 Insert Delete GetRandom O(1)
<pre>
class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Integer> map;    
    Random rand;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();   
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        
        return true;      
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int ind = map.get(val);
        
        if (ind == list.size() - 1) {
            map.remove(val);
            list.remove(list.size() - 1);
            return true;       
        }
        
        int lastInd = list.size() - 1;
        int lastVal = list.get(lastInd);
        map.put(lastVal, ind);
        map.remove(val);
        list.remove(list.size() - 1);
        list.set(ind, lastVal);
        
        return true;        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int i = rand.nextInt(list.size());
        
        return list.get(i);        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
</pre>

## 384 Shuffle an Array
<pre>
class Solution {
    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();       
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        
        int[] a = nums.clone();
        
        for (int j = 1; j < a.length; ++j) {
            int i = rand.nextInt(j + 1);
            swap(a, i, j);       
        }
        
        return a;        
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
</pre>

## 412 Fizz Buzz
<pre>
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }
        
        return list;        
    }
}
</pre>

## 454 4Sum II
<pre>
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < A.length; ++ i) {
            for (int j = 0; j < B.length; ++ j) {
                int curt = A[i] + B[j];
                if (!map.containsKey(curt)) {
                    map.put(curt, 0);
                }
                
                map.put(curt, map.get(curt) + 1);            
            }        
        }
        
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < C.length; ++ i) {
            for (int j = 0; j < D.length; ++ j) {
                int curt = C[i] + D[j];
                if (!map2.containsKey(curt)) {
                    map2.put(curt, 0);
                }
                
                map2.put(curt, map2.get(curt) + 1);            
            }        
        }
        
        int count = 0;
        
        for (int key: map.keySet()) {
            if (!map2.containsKey(0 - key)) {
                continue;
            }
            
            count += map.get(key) * map2.get(0 - key);       
        }
        
        return count;       
    }
}
</pre>
