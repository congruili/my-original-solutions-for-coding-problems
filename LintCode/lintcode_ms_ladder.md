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

