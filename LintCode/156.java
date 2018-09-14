// 156. Merge Intervals

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
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> rst = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return rst;
        }
        
        Comparator<Interval> comp = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start;
                }
                
                return a.end - b.end;
            }
        };
        
        Collections.sort(intervals, comp);
        
        Interval pre = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); ++i) {
            Interval curt = intervals.get(i);
            if (pre.end < curt.start) {
                rst.add(pre);
                pre = curt;
            } else {
                pre.end = Math.max(pre.end, curt.end);
            }
        }
        
        rst.add(pre);
        
        return rst;
    }
}