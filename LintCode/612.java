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
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (points == null || points.length == 0 || k == 0) {
            return new Point[0];
        }
        
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int aDis = getDis(a, origin);
                int bDis = getDis(b, origin);
                
                if (aDis != bDis) {
                    return bDis - aDis;
                } else if (a.x != b.x) {
                    return b.x - a.x;
                } else {
                    return b.y - a.y;
                }
            }
        };
        
        Queue<Point> q = new PriorityQueue<>(k, comp);
        
        for (Point p: points) {
            q.offer(p);
            if (q.size() > k) {
                q.poll();
            }
        }
        
        Point[] rst = new Point[k];
        int ind = k - 1;
        while (!q.isEmpty()) {
            rst[ind--] = q.poll();
        }
        
        return rst;
    }
    
    private int getDis(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}