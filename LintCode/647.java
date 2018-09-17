// 647. Find All Anagrams in a String

public class Solution {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return rst;
        }
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        
        int[] delta = new int[256];
        for (int i = 0; i < pc.length; ++i) {
            delta[sc[i]]++;
            delta[pc[i]]--;
        }
        
        int absSum = 0;
        for (int i = 0; i < 256; ++i) {
            absSum += Math.abs(delta[i]);
        }
        
        if (absSum == 0) {
            rst.add(0);
        }
        
        for (int i = pc.length; i < sc.length; ++i) {
            int l = sc[i - pc.length];
            int r = sc[i];
            absSum = absSum - Math.abs(delta[l]) - Math.abs(delta[r]);
            delta[l]--;
            delta[r]++;
            absSum = absSum + Math.abs(delta[l]) + Math.abs(delta[r]);
            
            if (absSum == 0) {
                rst.add(i - pc.length + 1);
            }
        }
        
        return rst;
    }
}