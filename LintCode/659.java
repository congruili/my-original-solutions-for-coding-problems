// 659. Encode and Decode Strings

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
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
        List<String> list = new ArrayList<>();
        
        int ind = 0;
        while (ind < str.length()) {
            int len = 0;
            while (Character.isDigit(str.charAt(ind))) {
                len = len * 10 + str.charAt(ind) - '0';
                ind++;
            }
            
            ind++;
            String curt = str.substring(ind, ind + len);
            list.add(curt);
            ind += len;
        }
        
        return list;
    }
}