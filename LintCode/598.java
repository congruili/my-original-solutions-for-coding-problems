// 598. Zombie in Matrix

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        
        Queue<Point> q = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }
        
        int step = 0;
        int[] xUpdate = {-1, 1, 0, 0};
        int[] yUpdate = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                Point curt = q.poll();
                for (int k = 0; k < 4; ++k) {
                    int newX = curt.x + xUpdate[k];
                    int newY = curt.y + yUpdate[k];
                    
                    if (isValid(grid, newX, newY) && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        q.offer(new Point(newX, newY));
                    }
                }
            }
            
            step++;
        }
        
        int nPeople = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        
        return step - 1;
    }
    
    private boolean isValid(int[][] grid, int x, int y) {
        int n = grid.length, m = grid[0].length;
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}