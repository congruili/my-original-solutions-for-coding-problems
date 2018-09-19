// 124. Longest Consecutive Sequence

public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i: num) {
            set.add(i);
        }
        
        int maxLen = 1;
        
        while (!set.isEmpty()) {
            int i = set.iterator().next();

            int left = i;
            int right = i + 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            
            maxLen = Math.max(right - left - 1, maxLen);
        }
        
        return maxLen;
    }
}