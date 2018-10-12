// 398. Longest Continuous Increasing Subsequence II

public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    int[][] dp; 
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        int rst = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }
        
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int curt = dfs(matrix, i, j);
                rst = Math.max(rst, curt);           
            }
        }
        
        return rst;       
    }
    
    private int dfs(int[][] matrix, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }   
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rst = 1;
        for (int k = 0; k < 4; ++k) {
            int new_x = x + dx[k];
            int new_y = y + dy[k];
            
            if (isValid(matrix, new_x, new_y) && matrix[new_x][new_y] < matrix[x][y]) {
                rst = Math.max(rst, dfs(matrix, new_x, new_y) + 1);
            }        
        }
        
        dp[x][y] = rst;        
        return rst;        
    }
    
    private boolean isValid(int[][] matrix, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;        
    }
}