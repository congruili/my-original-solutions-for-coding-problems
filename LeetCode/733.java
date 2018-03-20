class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {     
        if (image[sr][sc] == newColor) return image;
        int oldColor = image[sr][sc];
        
        bfs(image, oldColor, newColor, sr, sc); 
        
        return image;        
    }
    
    public void bfs(int[][] image, int oldColor, int newColor, int curtRow, int curtCol) {
        int row = image.length;
        int col = image[0].length;
        if (curtRow < 0 || curtRow >= row || curtCol < 0 || curtCol >= col) return;
        if (image[curtRow][curtCol] != oldColor) return;
        image[curtRow][curtCol] = newColor;
        bfs(image, oldColor, newColor, curtRow - 1, curtCol);
        bfs(image, oldColor, newColor, curtRow + 1, curtCol);
        bfs(image, oldColor, newColor, curtRow, curtCol - 1);
        bfs(image, oldColor, newColor, curtRow, curtCol + 1);        
    } 
}