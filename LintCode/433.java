class Point {
    int row, col;
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int rst = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j]) {
                    rst++;
                    BFS(grid, i, j);
                }
            }
        }
        
        return rst;
    }
    
    private void BFS(boolean[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        int[] rowUpdate = {0, 0, -1, 1};
        int[] colUpdate = {-1, 1, 0, 0};
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col));
        grid[row][col] = false;
        
        while (!q.isEmpty()) {
            Point curt = q.poll();
            for (int i = 0; i < 4; ++i) {
                int newRow = curt.row + rowUpdate[i];
                int newCol = curt.col + colUpdate[i];
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol]) {
                    q.offer(new Point(newRow, newCol));
                    grid[newRow][newCol] = false;
                }
            }
        }
    }
    
    private boolean isValid(boolean[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}