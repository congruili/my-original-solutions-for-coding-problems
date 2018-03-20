public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() <= 1) return s;
        int rst = 1;
        int start = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            int len = findLongestPalin(s, i, i);
            if (len > rst) {
                rst = len;
                start = i - len / 2;
            }
            
            len = findLongestPalin(s, i, i + 1);
            if (len > rst) {
                rst = len;
                start = i - len / 2 + 1;
            }
        }
        
        return s.substring(start, start + rst);
    }
    
    private int findLongestPalin(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            
            len += left == right ? 1 : 2;
            
            left--;
            right++;
        }
        
        return len;
    }
}