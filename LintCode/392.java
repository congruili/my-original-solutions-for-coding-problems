// 392. House Robber

public class Solution {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;        
        if (len == 1) {
            return (long)A[0];
        }
             
        long[] rst = new long[len];
        rst[0] = (long)A[0];
        rst[1] = (long)Math.max(A[0], A[1]);        
        
        for (int i = 2; i < len; ++i) {
            rst[i] = Math.max(rst[i - 2] + A[i], rst[i - 1]);            
        }
        
        return rst[len - 1];        
    }
}