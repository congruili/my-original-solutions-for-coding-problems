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
    
    int[][] image = {
      {0, 1, 1, 1, 1, 1, 1}, // 0
      {1, 0, 1, 1, 0, 1, 1}, // 1 
      {0, 0, 1, 0, 0, 0, 1}, // 2
      {0, 0, 1, 0, 1, 0, 1}, // 3
      {1, 1, 1, 0, 0, 0, 1}, // 4
    // 0  1  2  3  4  5  6
    };
    // [[(0, 4), (1, 5)], [(1, 1), (2, 2)]]
    
    int[][] copy = image.clone();
    findRec(image);
    findShape(copy);
    
    // System.out.print(rst2.size());
    
    
    for (List<Integer> list: rst2) {
      for (int i: list) {
        System.out.print(i);  
        System.out.print(" ");
      }      
      System.out.println();
    }

  }
  
  public static List<List<Integer>> rst = new ArrayList<>();
  public static List<List<Integer>> rst2 = new ArrayList<>();
  
  
  public static void findShape(int[][] copy) {
    int m = copy.length, n = copy[0].length;
    
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (copy[i][j] == 0) {
          List<Integer> list = new ArrayList<>();
          helper2(copy, i, j, list); 
          rst2.add(list);
        }
      }
    }
    
  }
  
  public static void helper2(int[][] copy, int i, int j, List<Integer> list) {
    int m = copy.length, n = copy[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || copy[i][j] == 1) return;
    if (copy[i][j] == 0) {
      list.add(i);
      list.add(j);
      copy[i][j] = 1;
    }    
    
    helper2(copy, i + 1, j, list);
    helper2(copy, i - 1, j, list);
    helper2(copy, i, j - 1, list);
    helper2(copy, i, j + 1, list);
  
  }
  
  
  
  
  public static void findRec(int[][] image) {
    int m = image.length, n = image[0].length;
    
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (image[i][j] == 0 && (i == 0 || image[i - 1][j] == 1) && (j == 0 || image[i][j - 1] == 1)) {
          helper(image, i, j);
        }
      }    
    }
    
  }
  
  public static void helper(int[][] image, int i, int j) {
    int m = image.length, n = image[0].length;
    List<Integer> list = new ArrayList<>();
    list.add(i);
    list.add(j);
    
    int curtR = i, curtC = j;
    while (curtR < m && image[curtR][j] == 0) curtR++;
    while (curtC < n && image[i][curtC] == 0) curtC++;
    
    list.add(curtR - 1);
    list.add(curtC - 1);  
    
    rst.add(list);  
  }
}


/* 

int[][] image = {
  {1, 1, 1, 1, 1, 1, 1}, // 0
  {1, 1, 1, 1, 1, 1, 1}, // 1 
  {1, 1, 1, 0, 0, 0, 1}, // 2
  {1, 1, 1, 0, 0, 0, 1}, // 3
  {1, 1, 1, 1, 1, 1, 1}, // 4
// 0  1  2  3  4  5  6
};

Output:
[(2, 3), (3, 5)]
 */