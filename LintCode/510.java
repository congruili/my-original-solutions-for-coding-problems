// 510. Maximal Rectangle

public class Solution {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        int maxA = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxA;
        }
        
        int n = matrix.length, m = matrix[0].length;
        
        int[] hs = new int[m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!matrix[i][j]) {
                    hs[j] = 0;
                } else {
                    hs[j]++;
                }            
            }
            
            maxA = Math.max(maxA, findMax(hs));           
        }
        
        return maxA;        
    }
    
    private int findMax(int[] hs) {
        int maxA = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= hs.length; ++i) {
            int curt = i == hs.length ? -1 : hs[i];
            while (!stack.isEmpty() && curt < hs[stack.peek()]) {
                int h = hs[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxA = Math.max(maxA, h * w);
            }
            
            stack.push(i);       
        }
        
        return maxA;
    } 
}