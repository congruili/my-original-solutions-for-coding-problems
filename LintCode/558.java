// 558. Sliding Window Matrix Maximum

public class Solution {
    /**
     * @param matrix: an integer array of n * m matrix
     * @param k: An integer
     * @return: the maximum number
     */
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // write your code here
        if (k == 0 || matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int n = matrix.length, m = matrix[0].length;
        
        if (k > n || k > m) {
            return 0;
        }
        
        int[][] sums = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] + matrix[i][j] - sums[i][j];
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i + k - 1 < n; ++i) {
            for (int j = 0; j + k - 1 < m; ++j) {
                int curtSum = sums[i + k][j + k] - sums[i + k][j] - sums[i][j + k] + sums[i][j];
                maxSum = Math.max(maxSum, curtSum);           
            }
        }
        
        return maxSum;       
    }
}