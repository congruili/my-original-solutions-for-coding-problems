// 611. Knight Shortest Path

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        Queue<Point> q = new LinkedList<>();
        q.offer(source);
        grid[source.x][source.y] = true;
        
        int step = 0;
        int[] xUpdate = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] yUpdate = {2, -2, 2, -2, 1, -1, 1, -1};
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int s = 0; s < size; ++s) {
                Point curt = q.poll();
                if (curt.x == destination.x && curt.y == destination.y) {
                    return step;
                }
                
                for (int k = 0; k < 8; ++k) {
                    int newX = curt.x + xUpdate[k];
                    int newY = curt.y + yUpdate[k];
                    if (isValid(grid, newX, newY) && !grid[newX][newY]) {
                        q.offer(new Point(newX, newY));
                        grid[newX][newY] = true;
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
    boolean isValid(boolean[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}