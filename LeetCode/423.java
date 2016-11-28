public class Solution {
    public String originalDigits(String s) {
        int[] letters = new int[26];
        for (char c: s.toCharArray()) letters[c - 'a']++;
        int[] count = new int[10];
        
        count[0] = letters['z' - 'a'];
        count[2] = letters['w' - 'a'];
        count[4] = letters['u' - 'a'];
        count[6] = letters['x' - 'a'];
        count[8] = letters['g' - 'a'];
        count[1] = letters['o' - 'a'] - count[0] - count[2] - count[4];
        count[3] = letters['h' - 'a'] - count[8];
        count[5] = letters['f' - 'a'] - count[4];
        count[7] = letters['v' - 'a'] - count[5];
        count[9] = letters['i' - 'a'] - count[5] - count[6] - count[8];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; ++i) {
            for (int j = 1; j <= count[i]; ++j) sb.append(i);
        }
        
        return sb.toString();
    }
}