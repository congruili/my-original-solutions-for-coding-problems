//Problem        : License to Hack
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.8
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.*;
//Your submission should *ONLY* use the following class name
public class LicenseToHack {

    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
       String s = in.nextLine();
       int n = in.nextInt();
       
       if (s == null || s.length() <= 1 || n <= 1) {
           System.out.println(s);
           return;
       }
       int len = s.length();
       
       StringBuilder sb = new StringBuilder();
       char[] letters = s.toCharArray();
       
       boolean flag = true;
       
       for (int i = 0; i < len; i += n) {
           int begin = i;
           int end = Math.min(len, i + n);
           if (flag) {
               for (int j = end - 1; j >= begin; --j) sb.append(letters[j]);
           } else {
               for (int j = begin; j < end; ++j) sb.append(letters[j]);
           }
           
           flag = !flag;
       } 
             
       System.out.println(sb.toString());
    }

}
