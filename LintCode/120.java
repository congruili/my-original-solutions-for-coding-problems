// 120. Word Ladder

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        dict.add(start);
        dict.add(end);
        
        Queue<String> q = new LinkedList<>();
        Set<String> used = new HashSet<>();
        q.offer(start);
        used.add(start);
        int step = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String curt = q.poll();
                if (curt.equals(end)) {
                    return step;
                }
                
                for (String next: getNextWords(curt, dict)) {
                    if (!used.contains(next)) {
                        q.offer(next);
                        used.add(next);
                    }
                }
            }
            
            step++;
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String s, Set<String> dict) {
        List<String> rst = new ArrayList<>();
        
        for (int i = 0; i < s.length(); ++i) {
            for (char c = 'a'; c <= 'z'; ++c) {
                if (c != s.charAt(i)) {
                    String curt = replace(s, i, c);
                    if (dict.contains(curt)) {
                        rst.add(curt);
                    }
                }
            }
        }
        
        return rst;
    }
    
    private String replace(String s, int i, char c) {
        char[] sc = s.toCharArray();
        sc[i] = c;
        return new String(sc);
    }
}