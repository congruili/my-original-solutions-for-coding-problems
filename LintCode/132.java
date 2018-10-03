// 132. Word Search II

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> rst = new ArrayList<>();
        
        if (words == null || words.size() == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return rst;
        }
        
        for (String s: words) {
            if (find(s, board)) {
                rst.add(s);
            }            
        }
        
        return rst;        
    }
    
    private boolean find(String s, char[][] board) {
        int n = board.length, m = board[0].length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[n][m];
                    if (dfs(s, 0, i, j, board, visited)) {
                        return true;
                    }                    
                }            
            }
        }
        
        return false;    
    }
    
    private boolean dfs(String s, int ind, int i, int j, char[][] board, boolean[][] visited) {
        if (ind == s.length()) {
            return true;
        }
        
        int n = board.length, m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != s.charAt(ind)) {
            return false;
        }   
    
        visited[i][j] = true;
        
        if (dfs(s, ind + 1, i + 1, j, board, visited)) {
            return true;
        }
        
        if (dfs(s, ind + 1, i - 1, j, board, visited)) {
            return true;
        }
        
        if (dfs(s, ind + 1, i, j + 1, board, visited)) {
            return true;
        }
        
        if (dfs(s, ind + 1, i, j - 1, board, visited)) {
            return true;
        }
        
        visited[i][j] = false;
        
        return false;  
    }
}