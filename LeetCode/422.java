// http://bookshadow.com/weblog/2016/10/16/leetcode-valid-word-square/
public class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        
        int m = words.size();
        int n = words.get(0).length();
        if (m != n) return false;
        List<String> copy = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            StringBuilder sb = new StringBuilder();
            int len = words.get(i).length();
            if (len > m) return false;
            
            for (int j = 0; j < len; ++j) {
                if (words.get(j).length() < i + 1) return false;
                sb.append(words.get(j).charAt(i));
            }

            for (int j = len; j < m; ++j) {
                if (words.get(j).length() >= i + 1) return false;
            }

            copy.add(sb.toString());
        }

        for (int i = 0; i < m; ++i) {
            if (!words.get(i).equals(copy.get(i))) return false;
        }

        return true;   
        
    }
}