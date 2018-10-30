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
