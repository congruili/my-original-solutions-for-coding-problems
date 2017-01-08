public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        
        if (Math.abs(lenS - lenT) > 1) return false;
        
        int i = 0;
        while (i < lenS && i < lenT) {
            if (s.charAt(i) != t.charAt(i)) {
                if (lenS == lenT) return s.substring(i + 1).equals(t.substring(i + 1));
                else if (lenS > lenT) return s.substring(i + 1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i + 1));
            }
            
            i++;
        }
        
        if (lenS == lenT) return false;
        return true;
    }
}