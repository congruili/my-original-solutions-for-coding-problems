// 386. Longest Substring with At Most K Distinct Characters

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int left = 0;
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        int count = 0;
        
        for (int i = 0; i < sc.length; ++i) {
            if (map[sc[i]] == 0) {
                count++;
            }
            map[sc[i]]++;
            
            while (count > k) {
                map[sc[left]]--;
                if (map[sc[left]] == 0) {
                    count--;
                }
                
                left++;
            }
            
            maxLen = Math.max(maxLen, i - left + 1);
        }
        
        return maxLen;
    }
}