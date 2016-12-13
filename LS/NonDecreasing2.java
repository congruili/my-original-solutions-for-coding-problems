public class NonDecreasing2 {

    public static void main(String[] args) {
        int[][] grid = {{8, 2, 4}, {0, 7, 1}, {3, 7, 9}};

        int rst = findLongest(grid);

        System.out.println(rst);

    }

    public static int findLongest(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (start(grid, i, j)) {
                    dfs(grid, used, i, j, 1);
                }
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
                if (grid[row][col] < grid[i][j]) continue;
                dfs(grid, used, row, col, len + 1);
            }
        }

        used[i][j] = false;


    }

    public static boolean start(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        for (int x = -1; x <= 1; ++x) {
            for (int y = -1; y <= 1; ++y) {
                if (x == 0 && y == 0) continue;
                int row = i + x;
                int col = j + y;
                if (row < 0 || row >= m || col < 0 || col >= n) continue;
                if (grid[row][col] < grid[i][j]) return false;
            }
        }

        return true;
    }
}
