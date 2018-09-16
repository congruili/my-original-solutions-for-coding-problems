// 206. Interval Sum

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
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        List<Long> rst = new ArrayList<>();
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return rst;
        }
        
        long[] sum = new long[A.length + 1];
        sum[0] = 0;
        for (int i = 0; i < A.length; ++i) {
            sum[i + 1] = sum[i] + (long)A[i];
        }
        
        for (Interval q: queries) {
            rst.add(sum[q.end + 1] - sum[q.start]);
        }
        
        return rst;
    }
}