// 395. Coins in a Line II

public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length <= 2) {
            return true;
        }
        
        int len = values.length;        
        int[] dp = new int[len];
        int[] sum = new int[len];
        
        dp[len - 1] = values[len - 1];
        sum[len - 1] = dp[len - 1];
        dp[len - 2] = values[len - 2] + values[len - 1];
        sum[len - 2] = dp[len - 2];
        
        for (int i = len - 3; i >= 0; --i) {
        sum[i] = sum[i + 1] + values[i];
        
        dp[i] = Math.max((values[i] + sum[i + 1] - dp[i + 1]), 
                         (values[i] + values[i + 1] + sum[i + 2] - dp[i + 2]));       
        }
        
        return dp[0] > sum[0] / 2;       
    }
}