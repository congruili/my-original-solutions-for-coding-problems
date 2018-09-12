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
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length, col = grid[0].length;
        int rst = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    rst++;
                }
            }
        }
        
        return rst;
    }
    
    private void bfs(boolean[][] grid, int i, int j) {
        int[] rowUpdate = {-1, 1, 0, 0};
        int[] colUpdate = {0, 0, -1, 1};
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            grid[p.row][p.col] = false;
            for (int k = 0; k < 4; ++k) {
                int newRow = p.row + rowUpdate[k];
                int newCol = p.col + colUpdate[k];
                
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol]) {
                    q.offer(new Point(newRow, newCol));
                }
            }
        }
    }
    
    boolean isValid(boolean[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}