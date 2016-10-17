public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> rst = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0) return rst;
        if (matrix[0] == null || matrix[0].length == 0) return rst;
        int m = matrix.length, n = matrix[0].length;
        
        boolean[][] pac = new boolean[m][n];
        for (int i = 0; i < m; ++i) pac[i][0] = true;
        for (int j = 0; j < n; ++j) pac[0][j] = true;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pac[i][j]) helper(pac, i, j, matrix);
            }
        }
        
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < m; ++i) atl[i][n - 1] = true;
        for (int j = 0; j < n; ++j) atl[m - 1][j] = true;
        
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (atl[i][j]) helper(atl, i, j, matrix);
            }
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pac[i][j] && atl[i][j]) rst.add(new int[]{i, j}); 
            }
        }
        
        return rst;
    }
    
    public void helper(boolean[][] ocean, int i, int j, int[][] matrix) {
        ocean[i][j] = true;
        int m = ocean.length, n = ocean[0].length;
        if (i - 1 >= 0 && !ocean[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) helper(ocean, i - 1, j, matrix);
        if (i + 1 < m && !ocean[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) helper(ocean, i + 1, j, matrix);
        if (j - 1 >= 0 && !ocean[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) helper(ocean, i, j - 1, matrix);
        if (j + 1 < n && !ocean[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) helper(ocean, i, j + 1, matrix);
    }
}