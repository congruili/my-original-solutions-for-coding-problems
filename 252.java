/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class Point {
        int time, label;
        public Point(int time, int label) {
            this.time = time;
            this.label = label;         
        }
    }
    
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) return true;

        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time != b.time) return a.time - b.time;
                return a.label - b.label;
            }
        };

        Queue<Point> queue = new PriorityQueue<Point>(comp);
        for (int i = 0; i < intervals.length; ++i) {
            queue.offer(new Point(intervals[i].start, 1));
            queue.offer(new Point(intervals[i].end, 0));        
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Point curt = queue.poll();
            if (curt.label == 1) count++;
            else count--;
            if (count > 1) return false;
        }
        
        return true;        
    }
}