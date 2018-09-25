// 663. Walls and Gates

public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        if (rooms == null || rooms.length == 0|| rooms[0].length == 0) {
            return;
        }
        
        int n = rooms.length, m = rooms[0].length;
        
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (rooms[i][j] == 0) {
                    xq.offer(i);
                    yq.offer(j);
                }
            }
        }
        
        while (!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();
            for (int k = 0; k < 4; ++k) {
                int new_x = x + dx[k];
                int new_y = y + dy[k];
                
                if (isValid(rooms, new_x, new_y) && rooms[new_x][new_y] == Integer.MAX_VALUE) {
                    rooms[new_x][new_y] = rooms[x][y] + 1;
                    xq.offer(new_x);
                    yq.offer(new_y);
                }
            }
        }
    }
    
    private boolean isValid(int[][] rooms, int x, int y) {
        int n = rooms.length, m = rooms[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}