// 158. Valid Anagram

public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[256];
        
        for (int i = 0 ; i < s.length(); ++i) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        
        for (int i = 0; i < 256; ++i) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}