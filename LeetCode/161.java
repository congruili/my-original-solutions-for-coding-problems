public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (Math.abs(lenS - lenT) > 1) return false;
        if (s.equals(t)) return false;

        int i = 0, j = 0;
        while (i < lenS && j < lenT) {
            char a = s.charAt(i);
            char b = t.charAt(j);
            if (a == b) {
                i++;
                j++;
            } else if (lenS == lenT) {
                i++;
                j++;
                break;
            } else if (lenS > lenT) {
                i++;
                break;
            } else {
                j++;
                break;
            }           
        }

        if (lenS == lenT) return s.substring(i).equals(t.substring(j));
        if (i == lenS ||  j == lenT) return true;
        return s.substring(i).equals(t.substring(j));
    }
}