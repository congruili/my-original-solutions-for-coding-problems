public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] can = new int[m + 1][n + 1];
        
        for (String s: strs) {
            int[] curt = count(s);
            int x = curt[0], y = curt[1];
            
            for (int i = m; i >= 0; --i) {
                for (int j = n; j >= 0; --j) {
                    if (i >= x && j >= y) can[i][j] = Math.max(can[i - x][j - y] + 1, can[i][j]);
                }
            }
            
        }
        
        int rst = 0;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) rst = Math.max(rst, can[i][j]);
        }
        
        return rst;
    }
    
    public int[] count(String s) {
        int[] rst = new int[2];
        for (char c: s.toCharArray()) {
            if (c == '0') rst[0]++;
            else rst[1]++;
        }
        
        return rst;
    }
}