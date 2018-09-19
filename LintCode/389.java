// 389. Valid Sudoku

public class Solution {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        for (int row = 0; row < 9; ++row) {
            if (!helper(board, row, row, 0, 8)) {
                return false;
            }
        }
        
        for (int col = 0; col < 9; ++col) {
            if (!helper(board, 0, 8, col, col)) {
                return false;
            }
        }
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!helper(board, 3 * i, 3 * i + 2, 3 * j, 3 * j + 2)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean helper(char[][] board, int row_begin, int row_end, int col_begin, int col_end) {
        Set<Character> set = new HashSet<>();
        
        for (int i = row_begin; i <= row_end; ++i) {
            for (int j = col_begin; j <= col_end; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (set.contains(board[i][j])) {
                    return false;
                }
                
                set.add(board[i][j]);
            }
        }
        
        return true;
    }
}