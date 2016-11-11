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
    
    int[] K = {3, 4, 1};
    int[] P = {1, 2, 3};
    int B = 6;
    
    buy(K, P, B);
    
    for (List<Integer> list: rst) {
      for (int i: list) {
        System.out.print(i);
        System.out.print(" ");
      }
      System.out.println();    
    } 

  }
  
  
  public static List<List<Integer>> rst = new ArrayList<>();   
  
  public static void buy(int[] K, int[] P, int B) {    
    if (B == 0) return;
    List<Integer> list = new ArrayList<>();
    helper(K, P, list, B);
 
  }
  
  public static void helper(int[] K, int[] P, List<Integer> list, int remain) {
    if (remain == 0) {
      rst.add(new ArrayList<Integer>(list));
      return;    
    }
    
    for (int i = 0; i < K.length; ++i) {
      if (K[i] > 0 && P[i] <= remain) {
        K[i]--;
        list.add(P[i]);
        helper(K, P, list, remain - P[i]);
        K[i]++;
        list.remove(list.size() - 1);
      }      
    }
  
  }
}
