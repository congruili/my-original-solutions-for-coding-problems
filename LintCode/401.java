// 401. Kth Smallest Number in Sorted Matrix

class Point {
    int x, y, val;
    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length, m = matrix[0].length;
        
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return a.val - b.val;
            }
        };
        
        Queue<Point> q = new PriorityQueue<Point>(k, comp);
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new Point(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int count = 0;
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        
        while (count < k - 1) {
            Point curt = q.poll();
            for (int i = 0; i < 2; ++i) {
                int newX = curt.x + dx[i];
                int newY = curt.y + dy[i];
                
                if (newX < n && newY < m && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    q.offer(new Point(newX, newY, matrix[newX][newY]));
                }
            }
            count++;
        }
        
        return q.peek().val;
    }
}