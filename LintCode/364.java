// 364. Trapping Rain Water II

class Point {
    int x, y, h;
    public Point(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }    
}


public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */    
     
    public int trapRainWater(int[][] heights) {
        // write your code here
        int rst = 0;
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return rst;
        }
        
        int n = heights.length, m = heights[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return a.h - b.h;
            }
        };
        
        Queue<Point> q = new PriorityQueue<Point>(comp);
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i][0]) {
                q.offer(new Point(i, 0, heights[i][0]));
                visited[i][0] = true;
            }
            
            if (!visited[i][m - 1]) {
                q.offer(new Point(i, m - 1, heights[i][m - 1]));
                visited[i][m - 1] = true;
            }
        }
        
        for (int j = 0; j < m; ++j) {
            if (!visited[0][j]) {
                q.offer(new Point(0, j, heights[0][j]));
                visited[0][j] = true;
            }
            
            if (!visited[n - 1][j]) {
                q.offer(new Point(n - 1, j, heights[n - 1][j]));
                visited[n - 1][j] = true;
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
                
        while (!q.isEmpty()) {
            Point curt = q.poll();
            for (int k = 0; k < 4; ++k) {
                int new_x = curt.x + dx[k];
                int new_y = curt.y + dy[k];
                
                if (isValid(heights, new_x, new_y) && !visited[new_x][new_y]) {
                    Point next = new Point(new_x, new_y, heights[new_x][new_y]);
                    if (next.h < curt.h) {
                        rst += (curt.h - next.h);
                        next.h = curt.h;
                    }
                    
                    q.offer(next);
                    visited[new_x][new_y] = true;                
                }
            }       
        }
        
        return rst;       
    }
    
    private boolean isValid(int[][] heights, int x, int y) {
        int n = heights.length, m = heights[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;    
    }
}