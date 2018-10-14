// 476. Stone Game

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
        int[][] sum = new int[len][len];
        int[][] dp = new int[len][len];
        
        for (int i = 0; i < len; ++i) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < len; ++j) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }            
        }
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; ++mid) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j] + sum[i][j]);
                }
            }
        }
        
        return dp[0][len - 1];
    }
}
