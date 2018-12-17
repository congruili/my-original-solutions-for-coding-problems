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

### 435. Post Office Problem
<pre>
public class Solution {
    /**
     * @param A: an integer array
     * @param k: An integer
     * @return: an integer
     */
    public int postOffice(int[] A, int k) {
        // write your code here
        if (A == null || A.length <= k) {
            return 0;
        }
        
        Arrays.sort(A);
        int n = A.length;
        
        int[][] dis = oneOffice(A);
        
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i][1] = dis[1][i];
        }
        
        for (int l = 2; l <= k; ++l) {
            for (int i = l; i <= n; ++i) {
                dp[i][l] = Integer.MAX_VALUE;
                for (int j = l - 1; j < i; ++j) {
                    dp[i][l] = Math.min(dp[i][l], dp[j][l - 1] + dis[j + 1][i]);       
                }            
            }     
        }
        
        return dp[n][k];
        
    }
    
    private int[][] oneOffice(int[] A) {
        int n = A.length;    
        int[][] dis = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                int median = (i + j) / 2;
                for (int m = i; m <= j; ++m) {
                    dis[i][j] += Math.abs(A[m - 1] - A[median - 1]);            
                }
            }  
        }
        
        return dis;    
    }
}
</pre>

### 476. Stone Game
<pre>
public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            sums[i + 1] = sums[i] + A[i];       
        }
        
        int[][] dp = new int[len][len];
        
        for (int k = 1; k < len; ++k) {
            for (int i = 0; i + k < len; ++i) {
                dp[i][i + k] = Integer.MAX_VALUE;
                for (int j = i; j < i + k; ++j) {
                    dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + sums[i + k + 1] - sums[i]);                
                }        
            }
        }
        
        return dp[0][len - 1];
    }
}
</pre>

### 553. Bomb Enemy
<pre>
public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        
        int[] cols = new int[m];
        
        
        for (int j = 0; j < m; ++j) {
            cols[j] = 0;
            for (int i = 0; i < n; ++i) {
                if (grid[i][j] == 'E') {
                    cols[j] ++;
                } else if (grid[i][j] == 'W') {
                    break;                
                }        
            }     
        }
        
        int rst = 0;
        
        for (int i = 0; i < n; ++i) {
            int row = 0;
            for (int j = 0; j < m; ++j) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = 0;
                    for (int k = j; k < m && grid[i][k] != 'W'; ++k) {
                        if (grid[i][k] == 'E') {
                            row ++;
                        }              
                    }            
                }
                
                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < n && grid[k][j] != 'W'; ++k) {
                        if (grid[k][j] == 'E') {
                            cols[j] ++;                        
                        }
                    }            
                }
                
                if (grid[i][j] == '0') {
                    rst = Math.max(rst, row + cols[j]);
                }
            }
        }
        
        return rst;
        
    }
}
</pre>

### 168. Burst Balloons
<pre>
public class Solution {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] arr = helper(nums);
        
        int len = arr.length;
        int[][] dp = new int[len][len];
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 2; j < len; ++j) {
                for (int k = i + 1; k <= j - 1; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);               
                }        
            }   
        }
        
        return dp[0][len - 1];
        
    }
    
    private int[] helper(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 2];
        arr[0] = 1;
        for (int i = 0; i < len; ++i) {
            arr[i + 1] = nums[i];
        }
        
        arr[len + 1] = 1;
        
        return arr;
    }
}
</pre>

### 430. Scramble String
<pre>
public class Solution {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    Map<String, Boolean> map = new HashMap<>(); 
     
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1 == null || s2 == null) {
            return false;
        }
        
        if (map.containsKey(s1 + "#" + s2)) {
            return map.get(s1 + "#" + s2);
        }        
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.equals(s2)) {
            return true;
        }
        
        int len = s1.length();
        for (int i = 1; i < len; ++i) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
                map.put(s1 + "#" + s2, true);                
                return true;
            }
            
            if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
        }
        
        map.put(s1 + "#" + s2, false);        
        return false;
        
    }
}
</pre>

### 437. Copy Books
<pre>
public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        
        int n = pages.length;
        
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = pages[i] + sums[i];
        }
        
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1 ;i <= n; ++i) {
            dp[i][1] = sums[i];
        }
        
        for (int j = 2; j <= k; ++j) {
            for (int i = 1; i <= n; ++i) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 1; m <= i; ++m) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[m][j - 1], sums[i] - sums[m]));               
                }
            }     
        }
        
        return dp[n][k];
        
    }
}
</pre>

### 29. Interleaving String
<pre>
public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        
        int len1 = s1.length(), len2 = s2.length();
        
        if (len1 + len2 != s3.length()) {
            return false;    
        }
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        
        for (int i = 0; i < len1; ++i) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = true;
            } else {
                break;
            }
        }
        
        for (int j = 0; j < len2; ++j) {
            if (s2.charAt(j) == s3.charAt(j)) {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }
        
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if (dp[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] = true;
                } else if (dp[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] = true;
                }               
            }
        }
        
        return dp[len1][len2];
        
    }
}
</pre>

### 20. Dices Sum
<pre>
public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        double[][] dp = new double[n + 1][6 * n + 1];
        
        for (int i = 1; i <= 6; ++i) {
            dp[1][i] = 1.0 / 6;        
        }
        
        for (int i = 2; i <= n; ++i) {
            for (int j = i - 1; j <= 6 * (i - 1); ++j) {
                for (int k = 1; k <= 6; ++k) {
                    dp[i][j + k] += dp[i - 1][j] * 1.0 / 6;                    
                }            
            }        
        }
        
        List<Map.Entry<Integer, Double>> list = 
                new ArrayList<Map.Entry<Integer, Double>>();
        
        for (int i = n; i <= 6 * n; ++i) {
            list.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));            
        }
        
        return list;     
    }
}
</pre>

### 43. Maximum Subarray III
<pre>
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        
        int n = nums.length;
        int[][] local = new int[n + 1][k + 1];
        int[][] global = new int[n + 1][k + 1];
        
        for (int j = 1; j <= k; ++j) {
            local[j - 1][j] = Integer.MIN_VALUE;
            global[j - 1][j] = Integer.MIN_VALUE;
            for (int i = j; i <= n; ++i) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + nums[i - 1];
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }    
        }
        
        return global[n][k];        
    }
}
</pre>

### 393. Best Time to Buy and Sell Stock IV
<pre>
public class Solution {
    /**
     * @param K: An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int K, int[] prices) {
        // write your code here
        if (K == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        if (K > n / 2) {
            int rst = 0;
            for (int i = 1; i < n; ++i) {
                rst += Math.max(prices[i] - prices[i - 1], 0);
            }
            
            return rst;
        }
        
        int[][] local = new int[n][K + 1];
        int[][] global = new int[n][K + 1];
        
        for (int j = 1; j <= K; ++j) {
            for (int i = 1; i < n; ++i) {
                int diff = prices[i] - prices[i - 1];
                
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);         
            }    
        }
        
        return global[n - 1][K];     
        
    }
}
</pre>

### 89. k Sum
<pre>
public class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];
        
        for (int i = 0; i <= n; ++i) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i && j <= k; ++j) {
                for (int m = 0; m <= target; ++m) {
                    dp[i][j][m] += dp[i - 1][j][m];
                    if (m + A[i - 1] <= target) {
                        dp[i][j][m + A[i - 1]] += dp[i - 1][j - 1][m];                
                    }            
                }         
            }     
        }
        
        return dp[n][k][target];
        
    }
}
</pre>

### 91. Minimum Adjustment Cost
<pre>
public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        int n = A.size();
        
        int[][] dp = new int[n + 1][100 + 1];
        
        for (int i = 1; i <= 100; ++i) {
            dp[1][i] = Math.abs(A.get(0) - i);         
        }
        
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 100; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = 1; k <= 100; ++k) {
                    if (Math.abs(k - j) <= target) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));                
                    }            
                }             
            }     
        }
        
        int rst = Integer.MAX_VALUE;
        
        for (int i = 1; i <= 100; ++i) {
            rst = Math.min(rst, dp[n][i]);
        }
        
        return rst;
    }
}
</pre>

### 108. Palindrome Partitioning II
<pre>
public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        boolean[][] valid = new boolean[len][len];
        
        for (int i = 0; i < len; ++i) {
            valid[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                valid[i][i + 1] = true; 
            }
        }
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 2; j < len; ++j) {
                if (valid[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    valid[i][j] = true;
                }         
            }    
        }
        
        int[] rst = new int[len + 1];
        
        for (int i = 0; i < len; ++i) {
            rst[i + 1] = rst[i] + 1;
            for (int j = 0; j <= i; ++j) {
                if (valid[j][i]) {
                    rst[i + 1] = Math.min(rst[i + 1], rst[j] + 1);                
                }        
            }        
        }
        
        return rst[len] - 1;
        
    }
}
</pre>
