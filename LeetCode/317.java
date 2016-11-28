public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] reach = new int[m][n];
        int[][] dis = new int[m][n];
        int numB = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    numB++;
                    helper(i, j, grid, reach, dis);
                }
            }
        }
        
        int rst = Integer.MAX_VALUE;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && reach[i][j] == numB) rst = Math.min(rst, dis[i][j]);
            }
        }
        
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }
    
    public void helper(int i, int j, int[][] grid, int[][] reach, int[][] dis) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        boolean[][] used = new boolean[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int[] curt = queue.poll();
                
                for (int[] dir: dirs) {
                    int row = curt[0] + dir[0];
                    int col = curt[1] + dir[1];
                                    
                    if (row < 0 || row >= m || col < 0 || col >= n || used[row][col] || grid[row][col] != 0) continue;
                    reach[row][col]++;
                    dis[row][col] += level;
                    used[row][col] = true;
                    queue.offer(new int[] {row, col});
                }
            }
            
            level++;
        }
        
    }
}