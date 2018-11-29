//Problem        : Bit Flip
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.8
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static void main(String[] args)
    {

       Scanner in = new Scanner(System.in);
       String s = in.next();
       int[] nums = new int[32];
       for (int i = 0; i < 32; ++i) {
           nums[i] = s.charAt(i) - '0';
       }
       
       int rst = 0;
       
       int count = 0;
       for (int i: nums) {
           if (i == 1) {
               count ++;
           }
       }
       
       if (count == 32) {
           System.out.println(32);
           return;
       }
       
       for (int i = 0; i < 32; ++i) {
           if (nums[i] == 0) {
               nums[i] = 1;
               int left = i, right = i;
               while (left >= 0 && nums[left] == 1) {
                   left --;
               }
               
               while (right < 32 && nums[right] == 1) {
                   right ++;
               }
               
               rst = Math.max(rst, right - left - 1);
               
               nums[i] = 0;
            }
       }
       
       System.out.println(rst);
    }

}
