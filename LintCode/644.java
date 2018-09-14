// 644. Strobogrammatic Number

public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
        if (num == null) {
            return false;
        }
        
        if (num.length() == 0) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        
        
        char[] sc = num.toCharArray();
        int i = 0, j = sc.length - 1;
        while (i < j) {
            if (map.containsKey(sc[i]) && map.get(sc[i]) == sc[j]) {
                i++;
                j--;
                continue;
            }
            
            return false;
        }
        
        if (i > j) {
            return true;
        }
        
        if (sc[i] == '0' || sc[i] == '1' || sc[i] == '8') {
            return true;
        }
        
        return false;
    }
}