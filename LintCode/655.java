// 655. Add Strings

public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] ans = new int[Math.max(len1, len2)];
        
        int i = len1 - 1, j = len2 - 1;
        int ind = 0;
        
        while (i >= 0 || j >= 0) {
            int ans1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int ans2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            ans[ind++] = ans1 + ans2;
            i--;
            j--;
        }
        
        for (int k = 0; k < ans.length - 1; ++k) {
            ans[k + 1] += ans[k] / 10;
            ans[k] %= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int k = ans.length - 1; k >= 0; --k) {
            sb.append(ans[k]);
        }
        
        return sb.toString();
    }
}