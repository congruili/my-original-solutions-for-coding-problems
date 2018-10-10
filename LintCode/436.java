// 436. Maximal Square

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int n = matrix.length, m = matrix[0].length;        
        int rst = 0;
        
        for (int i = 0; i < n; ++i) {
            if (matrix[i][0] == 1) {
                rst = 1;
                break;
            }
        }
        
        for (int j = 0; j < m; ++j) {
            if (matrix[0][j] == 1) {
                rst = 1;
                break;
            }
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                int pre = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                if (matrix[i][j] == 1) {
                    matrix[i][j] = pre + 1;
                    rst = Math.max(rst, matrix[i][j]);
                }
            }
        }
        
        return rst * rst;       
    }
}