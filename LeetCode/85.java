public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int[] hs = new int[n];
        
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == '1') hs[j] = 1;
            else hs[j] = 0;
        }
        
        int rst = findMax(hs);
        
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') hs[j]++;
                else hs[j] = 0;
            }
            int curt = findMax(hs);
            rst = Math.max(rst, curt);
        }

        return rst;
    }
    
    public int findMax(int[] heights) {
        int len = heights.length;
        int max = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= len; ++i) {
            int curt = (i == len) ? -1 : heights[i];
            while (!stack.isEmpty() && curt <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
            
            stack.push(i);
        }
        
        return max;
    }
}