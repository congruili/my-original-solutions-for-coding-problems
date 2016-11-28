public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) return false;
        char[] letters = s.toCharArray();
        
        for (int i = 0; i < letters.length - 1; ++i) {
            if (letters[i] == '+' && letters[i + 1] == '+') {
                letters[i] = '-';
                letters[i + 1] = '-';
                String curt = new String(letters);
                if (!canWin(curt)) return true;
                letters[i] = '+';
                letters[i + 1] = '+';
            }
        }
        
        return false;
    }
}