public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int waysNCents(int n) {
        // Write your code here
        int[] rst = new int[n + 1];
        rst[0] = 1;
        int[] cand = {1, 5, 10, 25};
        
        for (int i = 0; i < cand.length; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (rst[j] != 0 && j + cand[i] <= n) rst[j + cand[i]] += rst[j];
            }
        }
        
        return rst[n];
    }
}