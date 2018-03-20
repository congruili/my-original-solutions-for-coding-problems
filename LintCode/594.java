public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int BASE = 1000000;
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null) return -1;
        
        int lenT = target.length();
        if (lenT == 0) return 0;
        
        int power = 1;
        for (int i = 0; i < lenT; ++i) {
            power = (power * 31) % BASE;
        }
        
        int targetCode = 0;
        for (char c: target.toCharArray()) {
            targetCode = (targetCode * 31 + c) % BASE;
        }
        
        int hashCode = 0;
        
        for (int i = 0; i < source.length(); ++i) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            
            if (i < lenT - 1) {
                continue;
            }
            
            if (i >= lenT) {
                hashCode -= source.charAt(i - lenT) * power % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            
            if (hashCode == targetCode) {
                if (source.substring(i - lenT + 1, i + 1).equals(target)) {
                    return i - lenT + 1;
                }
            }
        }
        
        return -1;
    }
}