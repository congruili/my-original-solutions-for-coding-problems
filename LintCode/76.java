// 76. Longest Increasing Subsequence

public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] rst = new int[nums.length];
        rst[0] = 1;
        int maxLen = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    rst[i] = Math.max(rst[i], rst[j]);
                }
            }
            
            rst[i]++;
            
            maxLen = Math.max(maxLen, rst[i]);
        }
        
        return maxLen;
    }
}