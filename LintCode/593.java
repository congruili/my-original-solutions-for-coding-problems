// 593. Stone Game II

public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;        
        int[] sum = new int[len * 2];
        sum[0] = A[0];
        
        for (int i = 1; i < len; ++i) {
            sum[i] = sum[i - 1] + A[i];
        }
        
        for (int i = len; i < 2 * len; ++i) {
            sum[i] = sum[i - 1] + A[i - len];
        }
        
        int[][] dp = new int[len * 2][len * 2];
        
        for (int i = len * 2 - 2; i >= 0; --i) {
            for (int j = i + 1; j < len * 2; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                int curtSum = sum[j];
                if (i != 0) {
                    curtSum -= sum[i - 1];
                }
                for (int mid = i; mid < j; ++mid) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j] + curtSum);  
                }            
            }            
        }
        
        int rst = dp[0][len - 1];
        
        for (int i = 0; i < len; ++i) {
            rst = Math.min(rst, dp[i][i + len - 1]);
        }
        
        return rst;       
    }
}