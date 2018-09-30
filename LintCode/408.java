// 408. Add Binary

public class Solution {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        int len1 = a.length(), len2 = b.length();
        
        String rst = "";
        int i = len1 - 1, j = len2 - 1;
        int carry = 0;
        
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            rst = sum % 2 + rst;
            carry = sum / 2;
            i--;
            j--;
        }
        
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + carry;
            rst = sum % 2 + rst;
            carry = sum / 2;
            i--;
        }
        
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            rst = sum % 2 + rst;
            carry = sum / 2;
            j--;
        }
        
        if (carry == 1) {
            rst = carry + rst;
        }
        
        return rst;
    }
}