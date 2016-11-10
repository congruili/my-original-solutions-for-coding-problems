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
    int[] nums = {3, 7, 0};
    List<Integer> rst = getNums(nums, 8700);
    
    for (int i: rst) {
      System.out.println(i);
    }
    

  }
  
  public static int target;
  
  public static List<Integer> getNums(int[] nums, int t) {
    target = t;
    List<Integer> rst = new ArrayList<>();
    if (nums == null || nums.length == 0) return rst;
    helper(0, nums, rst);
    return rst;  
  }
  
  public static void helper(int curt, int[] nums, List<Integer> rst) {
    for (int i: nums) {
      int next = curt * 10 + i;
      if (next == curt) {
        rst.add(next);
        return;
      }
      if (next < target) {
        rst.add(next);
        helper(next, nums, rst);
      }
    }  
  }
}