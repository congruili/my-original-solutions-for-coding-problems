// 582. Word Break II

public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    Map<String, List<String>> memo = new HashMap<>();
     
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> rst = new ArrayList<>();
        
        if (wordDict.contains(s)) {
            rst.add(s);
        }
        
        for (int i = 1; i < s.length(); ++i) {
            String curt = s.substring(0, i);
            if (!wordDict.contains(curt)) {
                continue;
            }
            
            String after = s.substring(i);
            List<String> segs = wordBreak(after, wordDict);
            
            for (String seg: segs) {
                rst.add(curt + " " + seg);
            }
        }
        
        memo.put(s, rst);
        return rst;
    }

}