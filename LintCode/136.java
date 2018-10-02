// 136. Palindrome Partitioning

public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null) {
            return rst;
        }
        
        boolean[][] isPalin = getMatrix(s);
        
        dfs(s, 0, new ArrayList<String>(), isPalin, rst);
        return rst;
    }
    
    private void dfs(String s, int ind, List<String> list, boolean[][] isPalin, List<List<String>> rst) {
        if (ind == s.length()) {
            rst.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = ind; i < s.length(); ++i) {
            if (!isPalin[ind][i]) {
                continue;
            }
            
            String curt = s.substring(ind, i + 1);
            list.add(curt);
            dfs(s, i + 1, list, isPalin, rst);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean[][] getMatrix(String s) {
        int len = s.length();
        
        boolean[][] isPalin = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            isPalin[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalin[i][i + 1] = true;
            }
        }
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                if (isPalin[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalin[i][j] = true;
                }
            }
        }
        
        return isPalin;
    }
}