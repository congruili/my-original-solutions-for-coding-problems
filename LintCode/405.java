// 405. Submatrix Sum

public class Solution {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        int[][] rst = new int[2][2];
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }
        
        int n = matrix.length, m = matrix[0].length;        
        int[][] sums = new int[n + 1][m + 1];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] + matrix[i][j] - sums[i][j];
            }
        }
        
        for (int i = 1; i <= n; ++i) {            
            for (int j = i; j <= n; ++j) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = 0; k <= m; ++k) {
                    int curtSum = sums[j][k] - sums[i - 1][k];
                    if (map.containsKey(curtSum)) {
                        int preCol = map.get(curtSum);
                        rst[0][0] = i - 1;
                        rst[0][1] = preCol;
                        rst[1][0] = j - 1;
                        rst[1][1] = k - 1;
                        return rst;
                    } else {
                        map.put(curtSum, k);
                    }                  
                }
            }         
        }
        
        return rst;       
    }
}