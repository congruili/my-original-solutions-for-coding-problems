// 465. Kth Smallest Sum In Two Sorted Arrays

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
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int n = A.length;
        int m = B.length;
        
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return a.val - b.val;
            }
        };
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<Point> q = new PriorityQueue<Point>(k, comp);
        q.offer(new Point(0, 0, A[0] + B[0]));
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
                    q.offer(new Point(newX, newY, A[newX] + B[newY]));
                }
            }
            
            count++;
        }
        
        return q.peek().val;
    }
}