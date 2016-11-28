// http://bookshadow.com/weblog/2016/10/02/leetcode-valid-word-abbreviation/

public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int ind1 = 0, ind2 = 0;        
        int len1 = word.length(), len2 = abbr.length();

        while(ind1 < len1 && ind2 < len2) {
            char c1 = word.charAt(ind1);
            char c2 = abbr.charAt(ind2);
            if (c2 >= '1' && c2 <= '9') {
                int begin = ind2;
                while (ind2 < len2 && Character.isDigit(abbr.charAt(ind2))) ind2++;
                int count = Integer.parseInt(abbr.substring(begin, ind2));
                ind1 += count;
            } else if (c1 == c2) {
                ind1++;
                ind2++;
            } else return false;
        }

        if (ind1 == len1 && ind2 == len2) return true;
        return false;
    }
}