// 654. Sparse Matrix Multiplication

public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        int n = A.length, p = A[0].length, m = B[0].length;
        
        int[][] rst = new int[n][m];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < p; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                if (B[i][j] != 0) {
                    list.add(j);
                }
            }
            
            map.put(i, list);
        }
        
        for (int i = 0; i < n; ++i) {
            for (int k = 0; k < p; ++k) {
                if (A[i][k] == 0) {
                    continue;
                }
                
                for (int j: map.get(k)) {
                    rst[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return rst;
    }
}