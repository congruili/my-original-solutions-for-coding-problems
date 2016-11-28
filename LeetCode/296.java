public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        int len = x.size();
        
        Collections.sort(x);
        Collections.sort(y);
        
        int left = 0, right = len - 1;
        int rst = 0;
        while (left + 1 <= right) {
            rst += x.get(right) - x.get(left);
            left++;
            right--;
        }
        
        left = 0;
        right = len - 1;
        while (left + 1 <= right) {
            rst += y.get(right) - y.get(left);
            left++;
            right--;
        }
        
        return rst;
    }
}