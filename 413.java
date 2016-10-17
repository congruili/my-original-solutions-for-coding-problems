public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int len = A.length;
        
        int curt = A[1] - A[0];
        int count = 2;
        int rst = 0;
        int i = 2;
        while (i < len) {
            while (i < len && A[i] - A[i - 1] == curt) {
                count++;
                i++;
            }
            if (count >= 3) rst += (count - 1) * (count - 2) / 2;
            if (i < len) curt = A[i] - A[i - 1];
            count = 2;
            i++;
        }
        
        return rst;
    }
}