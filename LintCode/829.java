// 829. Word Pattern II

public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String p, String s) {
        // write your code here        
        if (p == null || s == null) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
                
        return dfs(p, 0, s, 0, map, set);      
    }
    
    private boolean dfs(String p, int indP, String s, int indS, Map<Character, String> map, Set<String> set) {
        if (indP == p.length()) {
            return indS == s.length();
        }
        
        if (indS == s.length()) {
            return indP == p.length();
        }
        
        char charP = p.charAt(indP);

        if (map.containsKey(charP)) {
            String curt = map.get(charP);
        
            if (!s.substring(indS).startsWith(curt)) {
                return false;
            } else {
                return dfs(p, indP + 1, s, indS + curt.length(), map, set);
            }           
        }
        
        for (int i = indS; i < s.length(); ++i) {
            String curt = s.substring(indS, i + 1);
            if (set.contains(curt)) {
                continue;
            }
            
            map.put(charP, curt);
            set.add(curt);
            if (dfs(p, indP + 1, s, i + 1, map, set)) {
                return true;
            };
            set.remove(curt);
            map.remove(charP);                
        }
        
        return false;
    }
}