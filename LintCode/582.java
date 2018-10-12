// 582. Word Break II

public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
     
    Map<String, List<String>> map;
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        if (s == null || wordDict == null) {
            return new ArrayList<String>();
        }
        
        map = new HashMap<>();
        
        return dfs(s, wordDict);  
    }
    
    private List<String> dfs(String s, Set<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
    
        List<String> rst = new ArrayList<>();
        
        if (wordDict.contains(s)) {
            rst.add(s);
        }
        
        for (int i = 1; i < s.length(); ++i) {
            String prefix = s.substring(0, i);
            if (!wordDict.contains(prefix)) {
                continue;
            }
            
            String left = s.substring(i);
            List<String> cuts = dfs(left, wordDict);
            for (String cut: cuts) {
                rst.add(prefix + " " + cut);
            }
        }
        
        map.put(s, rst);
        return rst;   
    }
}