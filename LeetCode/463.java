public class Solution {
    
    int rst = 0;
    
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        
        boolean[][] used = new boolean[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) bfs(grid, i, j, used);
            }
        }
        
        return rst;
    }
    
    public void bfs(int[][] grid, int i, int j, boolean[][] used) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] != 1 || used[i][j]) return;
        used[i][j] = true;
        
        if (i == 0 || grid[i - 1][j] == 0) rst++;
        else bfs(grid, i - 1, j, used);
        
        if (i == m - 1 || grid[i + 1][j] == 0) rst++;
        else bfs(grid, i + 1, j, used);
        
        if (j == 0 || grid[i][j - 1] == 0) rst++;
        else bfs(grid, i, j - 1, used);
        
        if (j == n - 1 || grid[i][j + 1] == 0) rst++;
        else bfs(grid, i, j + 1, used);
    }
}