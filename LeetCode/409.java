public class Solution {
    public int longestPalindrome(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        
        int rst = 0;
        boolean odd = false;
        for (char c: map.keySet()) {
            int curt = map.get(c);
            if (curt % 2 == 1) {
                rst += (curt - 1);
                odd = true;
            } else rst += curt;
        }
        
        return odd == true ? rst + 1 : rst;
    }
}