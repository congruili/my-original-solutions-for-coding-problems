public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        int[] map = new int[256];
        
        for (int i = 0; i < sc.length; ++i) {
            if (map[sc[i]] == 0) {
                map[sc[i]] = tc[i];
            } else {
                if (map[sc[i]] != tc[i]) {
                    return false;
                }
            }
        } 
        
        int[] map2 = new int[256];
        
        for (int i = 0; i < tc.length; ++i) {
            if (map2[tc[i]] == 0) {
                map2[tc[i]] = sc[i];
            } else {
                if (map2[tc[i]] != sc[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
