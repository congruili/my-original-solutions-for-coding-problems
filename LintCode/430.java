// 430. Scramble String

public class Solution {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    Map<String, Boolean> map = new HashMap<>(); 
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1 == null || s2 == null) {
            return false;
        }
        
        if (map.containsKey(s1 + "#" + s2)) {
            return map.get(s1 + "#" + s2);
        }
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.equals(s2)) {
            return true;
        }
        
        int len = s1.length();
        
        if (len == 1) {
            return s1.equals(s2);
        }
        
        for (int i = 1;i < len; ++i) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
            
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }        
        }
        
        map.put(s1 + "#" + s2, false);
        
        return false;        
    }
}