// 659. Encode and Decode Strings

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        if (strs == null) {
            return null;
        }
        
        if (strs.size() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        if (str == null) {
            return null;
        }
        
        if (str.length() == 0) {
            return new ArrayList<String>();
        }
        
        List<String> list = new ArrayList<>();
        int ind = 0;
        
        while (ind < str.length()) {
            int val = 0;
            while (Character.isDigit(str.charAt(ind))) {
                val = val * 10 + str.charAt(ind) - '0';
                ind++;
            }
            ind++;
            String curt = str.substring(ind, ind + val);
            list.add(curt);
            
            ind += val;
        }
        
        return list;
    }
}