// 477. Surrounded Regions

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int n = board.length, m = board[0].length;
        
        for (int j = 0; j < m; ++j) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            
            if (board[n - 1][j] == 'O') {
                bfs(board, n - 1, j);
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            
            if (board[i][m - 1] == 'O') {
                bfs(board, i, m - 1);
            }
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int i, int j) {
        int n = board.length, m = board[0].length;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        
        xq.offer(i);
        yq.offer(j);
        board[i][j] = 'W';
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();
            
            for (int k = 0; k < 4; ++k) {
                int new_x = x + dx[k];
                int new_y = y + dy[k];
                
                if (isValid(board, new_x, new_y) && board[new_x][new_y] == 'O') {
                    board[new_x][new_y] = 'W';
                    xq.offer(new_x);
                    yq.offer(new_y);
                }
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        int n = board.length, m = board[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}