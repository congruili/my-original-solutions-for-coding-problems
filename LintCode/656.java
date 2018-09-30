// 656. Multiply Strings

public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // write your code here
        int len1 = num1.length(), len2 = num2.length();
        
        int[] ans = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; --i) {
            for (int j = len2 - 1; j >= 0; --j) {
                ans[i + j] += (num1.charAt(len1 - 1 - i) - '0') * (num2.charAt(len2 - 1 - j) - '0');
            }
        }
        
        for (int k = 0 ;k < ans.length - 1; ++k) {
            ans[k + 1] += ans[k] / 10;
            ans[k] = ans[k] % 10;
        }
        
        String rst = "";
        
        int k = ans.length - 1;
        
        while (k > 0 && ans[k] == 0) {
            k--;
        }
        
        for (; k >= 0; --k) {
            rst += ans[k];
        }
        
        return rst;
    }
}