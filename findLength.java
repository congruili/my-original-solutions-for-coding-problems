import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {   
  
  public static void main(String[] args) {
    int[][] grid = {{1, 1, 2, 2}, {0, 0, 2, 0}};
    
    int i = 1, j = 1;
    
    findLength(grid, i, j);
    
    System.out.print(rst);
  }
  
  public static int rst = 0;
  
  public static void findLength(int[][] grid, int i, int j) {
    int m = grid.length, n = grid[0].length;
    int target = grid[i][j];
    boolean[][] used = new boolean[m][n];    
    
    helper(grid, i, j, target, used);
  
  }
  
  public static void helper(int[][] grid, int i, int j, int target, boolean[][] used) {
    int m = grid.length, n = grid[0].length;    
    if (i < 0 || i >= m || j < 0 || j >= n) return;
    
    used[i][j] = true;
    
    if (i == 0 || grid[i - 1][j] != target) rst++;
    else if (!used[i - 1][j]) helper(grid, i - 1, j, target, used);
    
    if (i == m - 1 || grid[i + 1][j] != target) rst++;
    else if (!used[i + 1][j]) helper(grid, i + 1, j, target, used);
    
    if (j == 0 || grid[i][j - 1] != target) rst++;
    else if (!used[i][j - 1]) helper(grid, i, j - 1, target, used);
    
    if (j == n - 1 || grid[i][j + 1] != target) rst++;
    else if (!used[i][j + 1]) helper(grid, i, j + 1, target, used);
  
  }

  
}  
