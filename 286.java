public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) helper(rooms, i, j, 0);
            } 
        } 
    }

    public void helper(int[][] rooms, int i, int j ,int curt) {
        rooms[i][j] = curt;
        int m = rooms.length, n = rooms[0].length;
        if (i - 1 >= 0 && rooms[i - 1][j] > curt + 1) helper(rooms, i - 1, j, curt + 1);
        if (i + 1 < m && rooms[i + 1][j] > curt + 1) helper(rooms, i + 1, j, curt + 1);
        if (j - 1 >= 0 && rooms[i][j - 1] > curt + 1) helper(rooms, i, j - 1, curt + 1);
        if (j + 1 < n && rooms[i][j + 1] > curt + 1) helper(rooms, i, j + 1, curt + 1);
    }
}