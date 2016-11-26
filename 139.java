public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        
        int max = 0;
        for (String word: dict) {
            max = Math.max(max, word.length());
        }
        
        int len = s.length();
        boolean[] can = new boolean[len + 1];
        can[0] = true;
        
        for (int i = 1; i <= len; ++i) {
            for (int j = 1; j <= max && j <= i; ++j) {
                if (can[i - j] && dict.contains(s.substring(i - j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[len];
        
    }
}