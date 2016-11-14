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
    int[][] matrix = {{3, 5 ,9, -1}, {-4, -3, 0, 3}, {7, 0, -8, 5}};
    
    List<int[]> path = findMax(matrix);
    
    Collections.reverse(path);
    
    for (int[] row: path) {
      for (int i: row) {
        System.out.print(i);
        System.out.print(" ");
      }
      System.out.println();
    }

  }
  
  public static List<int[]> findMax(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] rst = new int[m][n];
    for (int j = 0; j < n; ++j) rst[0][j] = matrix[0][j];
    
    for (int i = 1; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        int max = Integer.MIN_VALUE;
        for (int k = Math.max(0, j - 1); k <= Math.min(n - 1, j + 1); ++k) {
          max = Math.max(rst[i - 1][k], max);
        }
        rst[i][j] = max + matrix[i][j];
      }
    } 
      
    int curt = Integer.MIN_VALUE;
  
    for (int j = 0; j < n; ++j) curt = Math.max(curt, rst[m - 1][j]);
    
    List<int[]> path = new ArrayList<int[]>();
    for (int i = m - 1; i >= 0; --i) {
      for (int j = 0; j < n; ++j) {
        if (rst[i][j] == curt) {
          path.add(new int[] {i, j});
          curt -= matrix[i][j];
          j = n;          
        }
      }     
    }
    
    return path;      
  } 
}

