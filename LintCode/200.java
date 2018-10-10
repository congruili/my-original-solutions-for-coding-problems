// 200. Longest Palindromic Substring

public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] sc = s.toCharArray();   
        int len = sc.length;   
        boolean[][] can = new boolean[len][len];
        
        int maxLen = 1;
        String rst = s.substring(0, 1);
                
        for (int i = 0; i < len; ++i) {
            can[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; ++i) {
            if (sc[i] == sc[i + 1]) {
                can[i][i + 1] = true;
                maxLen = 2;
                rst = s.substring(i, i + 2);
            }
        }
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                if (can[i + 1][j - 1] && sc[i] == sc[j]) {
                    can[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        rst = s.substring(i, j + 1);
                    }               
                }            
            }
        }
        
        return rst;
    }
}