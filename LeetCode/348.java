public class TicTacToe {

    /** Initialize your data structure here. */
    int[] rows, cols;
    int dig1, dig2;
    int n;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dig1 = 0;
        dig2 = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = 1;
        if (player == 2) val = -1;
        
        rows[row] += val;
        if (Math.abs(rows[row]) == n) return player;
        
        cols[col] += val;
        if (Math.abs(cols[col]) == n) return player;
        
        if (row == col) dig1 += val;
        if (Math.abs(dig1) == n) return player;
        
        if (row + col == n - 1) dig2 += val;
        if (Math.abs(dig2) == n) return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */