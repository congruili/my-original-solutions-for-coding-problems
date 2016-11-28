// http://www.cnblogs.com/grandyang/p/5351347.html

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int count = 0, rst = 0, i = 0, j = 0;
        int[] hash = new int[256];
        while (i < s.length() && count < k) {
            char c = s.charAt(i);
            hash[c]++;
            if (hash[c] == 1) count++;
            i++;
        }

        rst = i;

        for (; i < s.length(); ++i) {
            char c = s.charAt(i);
            hash[c]++;
            if (hash[c] == 1) count++;

            while (count > k) {
                char d = s.charAt(j);
                hash[d]--;
                if (hash[d] == 0) count--;
                j++;
            }

            rst = Math.max(rst, i - j + 1);
        }

        return rst;
    }
}