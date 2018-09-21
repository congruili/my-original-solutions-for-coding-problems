// 772. Group Anagrams

public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        List<List<String>> rst = new ArrayList<>();
        
        if (strs == null || strs.length == 0) {
            return rst;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s: strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            
            map.get(key).add(s);
        }
        
        for (String key: map.keySet()) {
            rst.add(map.get(key));
        }
        
        return rst;
    }
}