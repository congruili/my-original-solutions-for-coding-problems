// 778. Pacific Atlantic Water Flow

public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }
        
        int n = matrix.length, m = matrix[0].length;
        
        boolean[][] p = new boolean[n][m];
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        
        for (int j = 0; j < m; ++j) {
            xq.offer(0);
            yq.offer(j);
            p[0][j] = true;
        }
        
        for (int i = 1; i < n; ++i) {
            xq.offer(i);
            yq.offer(0);
            p[i][0] = true;
        }
        
        bfs(xq, yq, p, matrix);
        
        boolean[][] a = new boolean[n][m];
        
        for (int j = 0; j < m; ++j) {
            xq.offer(n - 1);
            yq.offer(j);
            a[n - 1][j] = true;
        }
        
        for (int i = 0; i < n - 1; ++i) {
            xq.offer(i);
            yq.offer(m - 1);
            a[i][m - 1] = true;
        }
        
        bfs(xq, yq, a, matrix);
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (p[i][j] && a[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    rst.add(list);
                }
            }
        }
        
        return rst;
    }
    
    private void bfs(Queue<Integer> xq, Queue<Integer> yq, boolean[][] ocean, int[][] matrix) {
        int n = ocean.length, m = ocean[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();
            for (int i = 0; i < 4; ++i) {
                int new_x = x + dx[i];
                int new_y = y + dy[i];
                
                if (isValid(new_x, new_y, ocean) && !ocean[new_x][new_y] && matrix[new_x][new_y] >= matrix[x][y]) {
                    ocean[new_x][new_y] = true;
                    xq.offer(new_x);
                    yq.offer(new_y);
                }
            }
        }
        
    }
    
    private boolean isValid(int i, int j, boolean[][] ocean) {
        int n = ocean.length, m = ocean[0].length;
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}