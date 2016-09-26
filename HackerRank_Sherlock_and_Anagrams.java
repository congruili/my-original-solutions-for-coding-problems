// https://www.hackerrank.com/challenges/sherlock-and-anagrams
// brute force solution

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        String[] strs = new String[size];

        for (int i = 0; i < size; ++i) strs[i] = in.next();     
        for (String s: strs) System.out.println(countAna(s)); 
    }
    
    public static int countAna(String s) {
        if (s == null || s.length() < 2) return 0;
        int len = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j <= len - i; ++j) {
                char[] letters = s.substring(j, j + i).toCharArray();
                Arrays.sort(letters);
                String s2 = new String(letters);
                if (!map.containsKey(s2)) map.put(s2, 0);
                map.put(s2, map.get(s2) + 1);   
            }
        }
        
        int count = 0;
        for (String key: map.keySet()) {
            int val = map.get(key);
            if (val > 1) count += (val * val - val) / 2;
        } 

        return count;
    }  
    
    public static boolean isAna(String s1, String s2) {
        int[] letters = new int[26];
        for (char c: s1.toCharArray()) {
            letters[c - 'a']++;
        }
        
        for (char c: s2.toCharArray()) {
            letters[c - 'a']--;
        }
        
        for (int i = 0; i < 26; ++i) {
            if (letters[i] != 0) return false;
        }
        
        return true;
    }
}