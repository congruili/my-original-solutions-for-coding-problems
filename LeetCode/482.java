public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        int dashes = 0, lenS = S.length();
        
        for (int i = 0; i < lenS; ++i) {
            if (S.charAt(i) == '-') dashes++;
        }
        
        int left = lenS - dashes;
        int res = left % K;
        
        StringBuilder sb = new StringBuilder();
        int count = 0, i = 0;
        
        if (res != 0) {
            while (count < res) {
                if (S.charAt(i) != '-') {
                    sb.append(S.charAt(i));
                    count++;
                }
                i++;
            }
            
            sb.append('-');
        }
        
        int countK = 0;
        while (count < left) {
            if (S.charAt(i) != '-') {
                sb.append(S.charAt(i));
                count++;
                countK++;
            }
            
            if (countK == K) {
                sb.append('-');
                countK = 0;
            }
            
            i++;
        }
        
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
}