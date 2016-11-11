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
    double[] probs = {0.5, 0.5, 0.4, 0.3};
    int target = 2;
    
    prob(probs, target);    
    System.out.print(rst); 

  }
  
  public static void prob(double[] probs, int target) {
    
    helper(probs, 1, 0, target);
  
  }
  
  public static double rst = 0;
  
  public static void helper(double[] probs, double curt, int ind, int remain) {
    
    if (ind == probs.length && remain == 0) {
      rst += curt;
      return;
    }
    
    if (ind == probs.length) return;
    
    if (remain > 0) helper(probs, curt * probs[ind], ind + 1, remain - 1);
    
    helper(probs, curt * (1 - probs[ind]), ind + 1, remain);
    
  }
  
}  
