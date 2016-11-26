//Problem        : Anagram Count
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.8
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.*;
//Your submission should *ONLY* use the following class name
public class AnagramCount {
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
       int n = in.nextInt();

       if (n <= 0) {
           System.out.println(0);
           return;
       }
       
       String[] strs = new String[n];
       
       for (int i = 0; i < n; ++i) {
           strs[i] = in.next();
       }
       
       HashMap<String, Integer> map = new HashMap<>();
       
       for (int i = 0; i < n; ++i) {
           String ana = getAna(strs[i].toLowerCase());
           if (!map.containsKey(ana)) map.put(ana, 0);
           map.put(ana, map.get(ana) + 1);
       }
            
       int rst = 0;
       
       for (String s: map.keySet()) {
           if (map.get(s) > 1) rst += map.get(s);
       }
       
       System.out.println(rst);
       
    }
    
    public static String getAna(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    } 

}
