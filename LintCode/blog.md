[https://zhengyang2015.gitbooks.io/lintcode/](https://zhengyang2015.gitbooks.io/lintcode/)

### 535. House Robber III
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
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] arr = helper(root);
        
        return Math.max(arr[0], arr[1]);
    }
    
    private int[] helper(TreeNode root) {
        int[] rst = new int[2];
    
        if (root == null) {
            return rst;
        }
        
        int[] left_arr = helper(root.left);
        int[] right_arr = helper(root.right);
        
        rst[0] = root.val + left_arr[1] + right_arr[1];     
        rst[1] = Math.max(left_arr[0], left_arr[1]) + Math.max(right_arr[0], right_arr[1]);
        
        return rst;    
    }
}
</pre>

### 514. Paint Fence
<pre>
public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return k;
        }
        
        int diff = k * (k - 1), same = k;
        
        for (int i = 3; i <= n; ++i) {
            int temp = diff;
            diff = (diff + same) * (k - 1);
            same = temp;                    
        }
        
        return diff + same;
        
    }
}
</pre>

### 516. Paint House II
<pre>
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int n = costs.length, k = costs[0].length;
        int first = Integer.MAX_VALUE;
        int ind = -1;
        int second = Integer.MAX_VALUE;
        
        for (int j = 0; j < k; ++j) {
            if (costs[0][j] < first) {
                second = first;
                first = costs[0][j];
                ind = j;
            } else if (costs[0][j] < second) {
                second = costs[0][j];
            }     
        }
        
        for (int i = 1; i < n; ++i) {
            int[] curt = new int[k];
            for (int j = 0; j < k; ++j) {
                if (j == ind) {
                    curt[j] = costs[i][j] + second;                    
                } else {
                    curt[j] = costs[i][j] + first;                    
                }        
            }
            
            first = Integer.MAX_VALUE;
            ind = -1;
            second = Integer.MAX_VALUE;
            
            for (int j = 0; j < k; ++j) {
                if (curt[j] < first) {
                    second = first;
                    first = curt[j];
                    ind = j;
                } else if (curt[j] < second) {
                    second = curt[j];
                }
            }
        }
        
        return first;
       
    }
}
</pre>

### 395. Coins in a Line II
<pre>
public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null) {
            return false;
        }
        
        int len = values.length;
        if (len == 0) {
            return false;
        }
        
        if (len <= 2) {
            return true;
        }
        
        int[] sums = new int[len];
        int[] dp = new int[len];
        
        dp[len - 1] = values[len - 1];
        sums[len - 1] = dp[len - 1];
        dp[len - 2] = values[len - 2] + values[len - 1];
        sums[len - 2] = dp[len - 2];
        
        for (int i = len - 3; i >= 0; --i) {
            sums[i] = sums[i + 1] + values[i];
            dp[i] = Math.max(values[i] + sums[i + 1] - dp[i + 1],
                             values[i] + values[i + 1] + sums[i + 2] - dp[i + 2]);
         
        }
        
        return dp[0] > sums[0] / 2;
    }
}
</pre>

### 396. Coins in a Line III
<pre>
public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        
        int len = values.length;
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            sums[i + 1] = sums[i] + values[i];
        }
        
        int[][] dp = new int[len][len];
        
        for (int i = 0; i < len; ++i) {
            dp[i][i] = values[i];        
        }
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                int sum = sums[j + 1] - sums[i];
                dp[i][j] = Math.max(values[i] + sum - dp[i + 1][j], values[j] + sum - dp[i][j - 1]);          
            }        
        }
        
        return dp[0][len - 1] > sums[len] / 2;
    }
}
</pre>

### 398. Longest Continuous Increasing Subsequence II
<pre>
public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dfs(dp, matrix, i, j);        
            }
        }
        
        int rst = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                rst = Math.max(rst, dp[i][j]);
            }        
        }
        
        return rst;        
    }
    
    private int dfs(int[][] dp, int[][] matrix, int i, int j) {
        int n = dp.length, m = dp[0].length;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        dp[i][j] = 1;
        
        for (int k = 0; k < 4; ++k) {
            int new_i = i + di[k];
            int new_j = j + dj[k];
            if (isValid(new_i, new_j, dp) && matrix[new_i][new_j] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], 1 + dfs(dp, matrix, new_i, new_j));
            }        
        }
        
        return dp[i][j];    
    }
    
    private boolean isValid(int i, int j, int[][] dp) {
        int n = dp.length, m = dp[0].length;
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
</pre>

### 631. Maximal Square II
<pre>
public class Solution {
    /**
     * @param matrix: a matrix of 0 an 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int n = matrix.length, m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        
        for (int j = 0; j < m; ++j) {
            if (matrix[0][j] == 1) {
                cols[j] = 0;
            } else {
                cols[j] = 1;
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (matrix[i][0] == 1) {
                rows[i] = 0;            
            } else {
                rows[i] = 1;
            }
        }
        
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = matrix[i][0];        
        }
        
        for (int j = 0; j < m; ++j) {
            dp[0][j] = matrix[0][j];        
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(rows[i], cols[j])) + 1;  
                    rows[i] = 0;
                    cols[j] = 0;                    
                } else {
                    rows[i] ++;
                    cols[j] ++;           
                }         
            }        
        }
        
        int rst = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                rst = Math.max(rst, dp[i][j]);
            }     
        }
        
        return rst * rst;   
        
    }
}
</pre>

### 164. Unique Binary Search Trees II
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
     * @paramn n: An integer
     * @return: A list of root
     */
    Map<Integer, List<TreeNode>> map; 
     
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return helper(1, n);      
    }
    
    private List<TreeNode> helper(int begin, int end) {
        List<TreeNode> list = new ArrayList<>(); 
        
        if (begin > end) {
            list.add(null);
            return list;
        } 
        
        for (int i = begin; i <= end; ++i) {
            List<TreeNode> leftRoots = helper(begin, i - 1);
            List<TreeNode> rightRoots = helper(i + 1, end);
            for (TreeNode left: leftRoots) {
                for (TreeNode right: rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);                
                }     
            }       
        }
        
        return list;    
    
    }
}
</pre>

