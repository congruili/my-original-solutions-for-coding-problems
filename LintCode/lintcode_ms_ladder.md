# 0-Easy

## 1350. Excel Sheet Column Title
<pre>
public class Solution {
    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        // write your code here
        if (n <= 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            n--;
            sb.insert(0, (char)(n % 26 + 'A'));
            
            n /= 26;        
        }
        
        return sb.toString();
    }
}
</pre>

## 1324. Count Primes
<pre>
public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
        if (n <= 2) {
            return 0;
        }
        
        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; j * i < n; ++j) {
                    notPrime[i * j] = true;                
                }            
            }        
        }
        
        return count;
    }
}
</pre>

## 453. Flatten Binary Tree to Linked List
<pre>
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        root.left = null;
        
        while (root.right != null) {
            root = root.right;
        }
        
        root.right = right;
    }
}
</pre>

## 372. Delete Node in a Linked List
<pre>
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
    /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null) {
            return;
        }
        
        node.val = node.next.val;
        node.next = node.next.next;       
    }
}
</pre>

## 167. Add Two Numbers
<pre>
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
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            curt.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            l1 = l1.next;
            l2 = l2.next;
            curt = curt.next;        
        }
        
        while (l1 != null) {
            int sum = carry + l1.val;
            curt.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            l1 = l1.next;
            curt = curt.next;        
        }
        
        while (l2 != null) {
            int sum = carry + l2.val;
            curt.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            l2 = l2.next;
            curt = curt.next;        
        }
        
        if (carry != 0) {
            curt.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
</pre>

## 67. Binary Tree Inorder Traversal
<pre>
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        
        Stack<TreeNode> stack = new Stack<>();        
        
        while (root != null) {
            stack.push(root);
            root = root.left;            
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            rst.add(node.val);
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }                        
            
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }            
            }        
        }
        
        return rst;        
    }
}
</pre>

## 56. Two Sum
<pre>
public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                int[] rst = new int[2];
                rst[0] = map.get(diff);
                rst[1] = i;
                return rst;            
            } else {
                map.put(nums[i], i);
            }        
        }
        
        return new int[] {-1, -1};
    }
}
</pre>

## 35. Reverse Linked List
<pre>
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
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;            
        }
        
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

## 451. Swap Nodes in Pairs
<pre>
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
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
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

## 433. Number of Islands (dfs)
<pre>
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j]) {
                    count ++;
                    dfs(grid, i, j);                
                }           
            }        
        }
        
        return count;        
    }
    
    private void dfs(boolean[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        
        if (!grid[i][j]) {
            return;
        }
        
        grid[i][j] = false;
        
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);   
    }
}
</pre>

## 433. Number of Islands (bfs)
<pre>
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j]) {
                    count ++;
                    bfs(grid, i, j);                
                }           
            }        
        }
        
        return count;        
    }
    
    private void bfs(boolean[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        
        Queue<Integer> q = new LinkedList<>();
        grid[i][j] = false;
        q.offer(i * m + j);
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!q.isEmpty()) {
            int curt = q.poll();
            int x = curt / m;
            int y = curt % m;
            
            for (int k = 0; k < 4; ++k) {
                int new_x = x + dx[k];
                int new_y = y + dy[k];
                if (isValid(grid, new_x, new_y) && grid[new_x][new_y]) {
                    q.offer(new_x * m + new_y);
                    grid[new_x][new_y] = false;
                }           
            }
        }        
  
    }
    
    private boolean isValid(boolean[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        return (i >= 0 && i < n && j >= 0 && j < m);   
    }
}
</pre>

## 433. Number of Islands (union find)
<pre>
class UnionFind {
    int[] father;
    int count;
    
    public UnionFind(int size) {
        father = new int[size]; 
        for (int i = 0; i < size; ++i) {
            father[i] = i;
        }
    }
    
    private int find(int x) {
        List<Integer> list = new ArrayList<>();
        while (x != father[x]) {
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
            count--;
            father[root_a] = root_b;        
        }    
    }
    
    public void setCount(int count) {
        this.count = count;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j]) {
                    count++;
                }           
            }        
        }
        
        UnionFind uf = new UnionFind(n * m);
        uf.setCount(count);
        
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j]) {
                    for (int k = 0; k < 4; ++k) {
                        int new_i = i + di[k];
                        int new_j = j + dj[k];
                        
                        if (!valid(grid, new_i, new_j) || !grid[new_i][new_j]) {
                            continue;
                        }
                        
                        uf.union(i * m + j, new_i * m + new_j);
                    }               
                }            
            }        
        }
        
        return uf.count;  
    }
    
    private boolean valid(boolean[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;        
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
</pre>

## 423. Valid Parentheses
<pre>
public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char c: sc) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char pre = stack.pop();
                if ((pre == '(' && c == ')') || (pre == '[' && c == ']') || (pre == '{' && c == '}')) {
                    continue;
                } else {
                    return false;                
                }           
            }       
        }
        
        return stack.isEmpty();
    }
}
</pre>

## 64. Merge Sorted Array
<pre>
public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int ind = m + n - 1;
        m --;
        n --;
        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                A[ind --] = A[m --];
            } else {
                A[ind --] = B[n --];
            }
        }
        
        while (n >= 0) {
            A[ind --] = B[n --];
        }
    }
}
</pre>

## 41. Maximum Subarray
<pre>
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int curtSum = 0;
        int minSum = 0;
        int rst = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            curtSum += nums[i];
            rst = Math.max(rst, curtSum - minSum);
            minSum = Math.min(minSum, curtSum);       
        }
        
        return rst;
    }
}
</pre>

## 13. Implement strStr()
<pre>
public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        
        if (target.length() == 0) {
            return 0;
        }
        
        int lenS = source.length(), lenT = target.length();
        
        for (int i = 0; i <= lenS - lenT; ++i) {
            if (source.charAt(i) == target.charAt(0)) {
                int j = 0;
                for (; j < target.length(); ++j) {
                    if (source.charAt(i + j) != target.charAt(j)) {
                        break;
                    }                
                } 
                
                if (j == target.length()) {
                    return i;
                }
            }        
        }
        
        return -1;
    }
}
</pre>

## 415. Valid Palindrome
<pre>
public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null) {
            return false;
        }
        
        if (s.length() < 2) {
            return true;
        }
        
        s = s.toLowerCase();
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isValid(s.charAt(l))) {
                l ++;
            }
            
            while (l < r && !isValid(s.charAt(r))) {
                r --;
            }
            
            if (l < r) {
                if (s.charAt(l) == s.charAt(r)) {
                    l ++;
                    r --;
                } else {
                    return false;
                }
            }         
        }
        
        return true;      
        
    }
    
    private boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
</pre>

# 1-Medium

## 1106. Maximum Binary Tree
<pre>
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param nums: an array
     * @return: the maximum tree
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        int ind = 0;
        int rootVal = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > rootVal) {
                rootVal = nums[i];
                ind = i;
            }
        }
        
        TreeNode root = new TreeNode(rootVal);
        
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, ind));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, ind + 1, nums.length));

        return root;
  
    }
}
</pre>

## 927. Reverse Words in a String II
<pre>
public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        if (str == null || str.length == 0) {
            return str;
        }
        
        int left = 0, right = 0;
        int len = str.length;
        swap(str, 0, len - 1);
        
        while (left < len) {
            while (right < len && str[right] != ' ') {
                right++;            
            }
            
            swap(str, left, right - 1);
            left = right + 1;
            right = left;            
        }
        
        return str;
    }
    
    private void swap(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;  
            i ++;
            j --;
        }    
    }
}
</pre>

## 419. Roman to Integer
<pre>
public class Solution {
    /**
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] sc = s.toCharArray();
        int rst = 0;
        int len = sc.length;
        rst += map.get(sc[len - 1]);
        
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(sc[i]) < map.get(sc[i + 1])) {
                rst -= map.get(sc[i]);
            } else {
                rst += map.get(sc[i]);
            }
        }
        
        return rst;
    }
}
</pre>

## 200. Longest Palindromic Substring
<pre>
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int len = s.length();
        boolean[][] valid = new boolean[len][len];
        
        int maxLen = 1;
        String rst = s.substring(0, 1);
        for (int i = 0; i < len; ++i) {
            valid[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                valid[i][i + 1] = true;
                rst = s.substring(i, i + 2);
                maxLen = 2;
            }        
        }
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                if (valid[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    valid[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        rst = s.substring(i, j + 1);                    
                    }                
                }
            }
        }
        
        return rst;        
  
    }
}
</pre>

## 380. Intersection of Two Linked Lists
<pre>
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode curt = headA;
        int lenA = 0;
        while (curt != null) {
            lenA ++;
            curt = curt.next;
        }
        
        curt = headB;        
        int lenB = 0;
        while (curt != null) {
            lenB ++;
            curt = curt.next;
        }
        
        while (lenA > lenB) {
            headA = headA.next;
            lenA --;
        }
        
        while (lenA < lenB) {
            headB = headB.next;
            lenB --;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;        
        }
        
        return headA;        
    }
}
</pre>

## 149. Best Time to Buy and Sell Stock
<pre>
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int rst = 0;
        int minVal = prices[0];
        
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - minVal;
            if (diff > rst) {
                rst = diff;
            }
            
            minVal = Math.min(minVal, prices[i]);        
        }
        
        return rst;       
    }
}
</pre>

## 123. Word Search
<pre>
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int n = board.length, m = board[0].length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }                
                }           
            }        
        }
        
        return false;        
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) {
            return true;
        }
        
        int n = board.length, m = board[0].length;
        
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        
        if (board[i][j] != word.charAt(ind)) {
            return false;
        }
        
        char tmp = board[i][j];
        
        board[i][j] = '#';
        boolean isValid = dfs(board, i + 1, j, word, ind + 1) || dfs(board, i - 1, j, word, ind + 1) || dfs(board, i, j + 1, word, ind + 1) || dfs(board, i, j - 1, word, ind + 1);
        
        board[i][j] = tmp;
        return isValid;       
    }    
}
</pre>

## 102. Linked List Cycle
<pre>
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
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;        
        }
        
        return false;
    }
}
</pre>

## 57. 3Sum
<pre>
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return rst;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < len - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    rst.add(list);
                    left ++;
                    right --;
                    
                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    } 
                    
                    while (left < right && nums[right] == nums[right + 1]) {
                        right --;
                    }               
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }         
            }
        }
        
        return rst;
    }
}
</pre>

## 7. Serialize and Deserialize Binary Tree
<pre>
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
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
                if (curt == null) {
                    sb.append("#,");
                    continue;                    
                }
                
                sb.append(curt.val + ",");
                q.offer(curt.left);
                q.offer(curt.right);           
            }       
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();       
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        
        int ind = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.offer(root);
        ind ++;
        
        while (ind < strs.length) {
            TreeNode curt = q.poll();
            if (strs[ind].equals("#")) {
                curt.left = null;            
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(strs[ind]));
                curt.left = left;
                q.offer(left);          
            }
            
            ind ++;
            
            if (strs[ind].equals("#")) {
                curt.right = null;            
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(strs[ind]));
                curt.right = right;
                q.offer(right);          
            }
            
            ind ++;        
        }
        
        return root;    
    }
}
</pre>

## 512. Decode Ways
<pre>
public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] sc = s.toCharArray();
        int len = sc.length;
        
        int[] dp = new int[sc.length + 1];
        dp[0] = 1;
        
        for (int i = 0; i < len; ++i) {
            if (sc[i] != '0') {
                dp[i + 1] += dp[i];
            }
            
            if (i > 0) {
                int curt = (sc[i - 1] - '0') * 10 + sc[i] - '0';
                if (curt >= 10 && curt <= 26) {
                    dp[i + 1] += dp[i - 1];
                }            
            }       
        }
        
        return dp[len];
    }
}
</pre>

## 374. Spiral Matrix
<pre>
public class Solution {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        
        int n = matrix.length, m = matrix[0].length;        
        int top = 0, bot = n - 1, left = 0, right = m - 1;
        
        while (top <= bot && left <= right) {
            list.addAll(helper(matrix, top, bot, left, right));     
            left ++;
            right --;
            top ++;
            bot --;            
        }
        
        return list;       
    }
    
    private List<Integer> helper(int[][] matrix, int top, int bot, int left, int right) {
        List<Integer> list = new ArrayList<>();        
        int n = matrix.length, m = matrix[0].length;
        
        for (int i = left; i <= right; ++i) {
            list.add(matrix[top][i]);
        }
        
        for (int i = top + 1; i <= bot; ++i) {
            list.add(matrix[i][right]);
        }
        
        if (top != bot) {        
            for (int i = right - 1; i >= left; --i) {
                list.add(matrix[bot][i]);   
            }       
        }
        
        if (left != right) {        
            for (int i = bot - 1; i >= top + 1; --i) {
                list.add(matrix[i][left]);
            }
        }
        
        return list;
    }
}
</pre>

## 159. Find Minimum in Rotated Sorted Array
<pre>
public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int begin = 0, end = nums.length - 1;
        
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] > nums[end]) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[begin] < nums[end]) {
            return nums[begin];
        }
        
        return nums[end];
    }
}
</pre>

## 94. Binary Tree Maximum Path Sum
<pre>
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
     
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        helper(root);
        
        return maxSum;       
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        if (root.val + left + right > maxSum) {
            maxSum = root.val + left + right;
        }
        
        return root.val + Math.max(left, right);
    }
}
</pre>

## 62. Search in Rotated Sorted Array
<pre>
public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int begin = 0, end = A.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            
            if (A[mid] < A[end]) {
                if (A[mid] <= target && target <= A[end]) {
                    begin = mid;
                } else {
                    end = mid;
                }           
            } else {
                if (A[begin] <= target && target <= A[mid]) {
                    end = mid;                
                } else {
                    begin = mid;
                }           
            }       
        }
        
        if (A[begin] == target) {
            return begin;
        }
        
        if (A[end] == target) {
            return end;
        }
        
        return -1;
    }
}
</pre>

# 2-Hard

## 1305. Integer to English Words
<pre>
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String rst = "";
        int i = 0;
        
        while (num > 0) {
            rst = helper(num % 1000) + THOUSANDS[i] + " " + rst;
            num /= 1000;
            i ++;            
        }
        
        return rst.trim();
    }
    
    private String helper(int x) {
        if (x == 0) {
            return "";
        }
        
        if (x < 20) {
            return LESS_THAN_20[x] + " ";
        }
        
        if (x < 100) {
            return TENS[x / 10] + " " + helper(x % 10);        
        }
        
        return LESS_THAN_20[x / 100] + " Hundred " + helper(x % 100);    
    }
}
</pre>

## 1346. Dungeon Game
<pre>
public class Solution {
    /**
     * @param dungeon: a 2D array
     * @return: return a integer
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // write your code here
        int begin = 1, end = Integer.MAX_VALUE;
        
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (can(mid, dungeon)) {
                end = mid;
            } else {
                begin = mid;
            }        
        }
        
        if (can(begin, dungeon)) {
            return begin;
        }
        
        return end;
    }
    
    private boolean can(int h, int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        
        if (h + dungeon[0][0] <= 0) {
            return false;
        }
        
        int[][] f = new int[n][m];
        f[0][0] = h + dungeon[0][0];
        
        for (int i = 1; i < n; ++i) {
            if (f[i - 1][0] == Integer.MIN_VALUE) {
                f[i][0] = Integer.MIN_VALUE;
                continue;
            }
            
            f[i][0] = f[i - 1][0] + dungeon[i][0];
            if (f[i][0] <= 0) {
                f[i][0] = Integer.MIN_VALUE;            
            }
        }
        
        for (int j = 1; j < m; ++j) {
            if (f[0][j - 1] == Integer.MIN_VALUE) {
                f[0][j] = Integer.MIN_VALUE;
                continue;
            }
            
            f[0][j] = f[0][j - 1] + dungeon[0][j];
            if (f[0][j] <= 0) {
                f[0][j] = Integer.MIN_VALUE;            
            }
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                
                if (f[i][j] == Integer.MIN_VALUE) {
                    continue;
                }
                
                f[i][j] += dungeon[i][j];
                
                if (f[i][j] <= 0) {
                    f[i][j] = Integer.MIN_VALUE;   
                }
            }        
        }
        
        
        return f[n - 1][m - 1] > 0;
    }
}
</pre>

## 134. LRU Cache
<pre>
class Node {
    int key, val;
    Node pre, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;    
    }
}


public class LRUCache {
    /*
    * @param capacity: An integer
    */
    
    Node head, tail;
    int cap;   
    
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        // do intialization if necessary
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.cap = capacity;
        map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        
        node.pre.next = node.next;
        node.next.pre = node.pre;
        
        moveToTail(node);
        return node.val;
    }
    
    private void moveToTail(Node node) {
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        node.next = tail;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        Node node = new Node(key, value);
        if (map.keySet().size() == cap) {
            Node delete = head.next;
            map.remove(delete.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        map.put(key, node);
        moveToTail(node);        
    }
}
</pre>

