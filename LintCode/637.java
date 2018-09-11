public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        if (word == null || abbr == null) {
            return false;
        }
        
        int i = 0, j = 0;
        char[] wc = word.toCharArray();
        char[] ac = abbr.toCharArray();
        
        while (i < wc.length && j < ac.length) {
            if (Character.isDigit(ac[j])) {
                if (ac[j] == '0') {
                    return false;
                }
                
                int val = 0;
                while (j < ac.length && Character.isDigit(ac[j])) {
                    val = val * 10 + ac[j] - '0';
                    j++;
                }
                i += val;
            } else {
                if (wc[i] != ac[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        
        return i == wc.length && j == ac.length;
    }
}
