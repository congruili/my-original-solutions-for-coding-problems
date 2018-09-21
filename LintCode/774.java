// 774. Repeated DNA

public class Solution {
    /**
     * @param s: a string represent DNA sequences
     * @return: all the 10-letter-long sequences 
     */
    public List<String> findRepeatedDna(String s) {
        // write your code here
        List<String> rst = new ArrayList<>();
        
        if (s == null || s.length() < 10) {
            return rst;
        }
        
        Set<String> set = new HashSet<>();
        Set<String> used = new HashSet<>();
        
        
        for (int i = 10; i <= s.length(); ++i) {
            String curt = s.substring(i - 10, i);
            if (set.contains(curt)) {
                if (!used.contains(curt)) {
                    rst.add(curt);
                    used.add(curt);
                }
            } else {
                set.add(curt);
            }
        }
        
        return rst;
    }
}