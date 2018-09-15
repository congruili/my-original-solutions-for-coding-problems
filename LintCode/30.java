// 30. Insert Interval

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

public class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> rst = new ArrayList<>();
        if (intervals == null) {
            rst.add(newInterval);
            return rst;
        }
        
        int ind = 0;
        int len = intervals.size();
        
        while (ind < len && intervals.get(ind).end < newInterval.start) {
            rst.add(intervals.get(ind));
            ind++;
        }
        
        while (ind < len && intervals.get(ind).start <= newInterval.end) {
            Interval curt = intervals.get(ind);
            newInterval = new Interval(Math.min(curt.start, newInterval.start), Math.max(curt.end, newInterval.end));
            ind++;
        }
        
        rst.add(newInterval);
        
        while (ind < len) {
            rst.add(intervals.get(ind));
            ind++;
        }
        
        return rst;
    }
}