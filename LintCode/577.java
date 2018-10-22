// 577. Merge K Sorted Interval Lists

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
 
class Point {
    int row, col;
    public Point(int row, int col) {
        this.row = row;
        this.col = col;    
    }
} 

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        List<Interval> rst = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return rst;
        }
        
        int size = intervals.size();
        
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int startDiff = intervals.get(a.row).get(a.col).start - intervals.get(b.row).get(b.col).start; 
                if (startDiff != 0) {
                    return startDiff;
                }
                
                return intervals.get(a.row).get(a.col).end - intervals.get(b.row).get(b.col).end;         
            }        
        };
        
        Queue<Point> q = new PriorityQueue<Point>(size, comp);
        
        for (int i = 0; i < size; ++i) {
            if (intervals.get(i).size() > 0) {
                q.offer(new Point(i, 0));            
            }       
        }
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            int curtRow = p.row;
            int curtCol = p.col;
            
            rst.add(intervals.get(curtRow).get(curtCol));
            curtCol++;
            if (intervals.get(curtRow).size() >= curtCol + 1) {
                q.offer(new Point(curtRow, curtCol));            
            }       
        }
        
        return merge(rst);        
    }
    
    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return rst;
        }
        
        Interval pre = intervals.get(0);
        
        int ind = 1;
        while (ind < intervals.size()) {
            Interval curt = intervals.get(ind);
            if (curt.start > pre.end) {
                rst.add(pre);
                pre = curt;
            } else {
                pre.end = Math.max(pre.end, curt.end);          
            } 
            ind++;
        }
        
        rst.add(pre);
        
        return rst;
    }
}