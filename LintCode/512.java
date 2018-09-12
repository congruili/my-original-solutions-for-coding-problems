public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] sc = s.toCharArray();
        int len = sc.length;
        int[] rst = new int[len + 1];
        rst[0] = 1;
        for (int i = 0; i < len; ++i) {
            if (sc[i] != '0') {
                rst[i + 1] += rst[i];
            }
            
            if (i > 0) {
                int val = (sc[i - 1] - '0') * 10 + sc[i] - '0';
                if (val >= 10 && val <= 26) {
                    rst[i + 1] += rst[i - 1];
                }
            }
        }
        
        return rst[len];
    }
}