import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

class NonDecreasing {

    /**
     * Take a rectangular grid of numbers and find the length
     * of the longest sub-sequence.
     * @return the length as an integer.
     */
    public static int longestSequence(int[][] grid) {
        // TODO: implement this function
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {                
                dfs(grid, used, i, j, 1);                                               
            }            
        }
        
        return max;        
    }
    
    public static int max = 0;
    
    public static void dfs(int[][] grid, boolean[][] used, int i, int j, int len) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j]) return;
        used[i][j] = true;
        max = Math.max(max, len);
        
        for (int x = -1; x <= 1; ++x) {
            for (int y = -1; y <= 1; ++y) {
                if (x == 0 && y == 0) continue;
                int row = i + x;
                int col = j + y;
                if (row < 0 || row >= m || col < 0 || col >= n) continue;
                if (used[row][col] || Math.abs(grid[row][col] - grid[i][j]) <= 3) continue;
                dfs(grid, used, row, col, len + 1);
            }            
        }
        
        used[i][j] = false;        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numRows = 0;
        int numCols = 0;
        String[] firstLine = reader.readLine().split("\\s+");
        numRows = Integer.parseInt(firstLine[0]);
        numCols = Integer.parseInt(firstLine[1]);

        int[][] grid = new int[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            String[] inputRow = reader.readLine().split("\\s+");

            for (int col = 0; col < numCols; col++) {
                grid[row][col] = Integer.parseInt(inputRow[col]);
            }
        }
        int length = longestSequence(grid);
        System.out.println(length);
    }
}
