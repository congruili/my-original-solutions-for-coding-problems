public class Solution {
    public String decodeString(String s) {
        CharSequence z = "[";
        if (!s.contains(z)) return s;
        
        int len = s.length();
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i < len) {
            char c = s.charAt(i);
            if (!Character.isDigit(c) && c != '[' && c != ']') {
                sb.append(c);
                i++;
            } else {
                left = i;
                int level = 0;
                while(s.charAt(i) != '[') i++;
                i++;
                level++;
                while(level != 0) {
                    if (s.charAt(i) == '[') level++;
                    else if (s.charAt(i) == ']') level--;
                    i++;
                }
                
                right = i;
                String curt = s.substring(left, right);
                int size = right - left;
                int cut = curt.indexOf("[");
                int count = Integer.parseInt(curt.substring(0, cut));
                String rep = curt.substring(cut + 1, size - 1);
                String decode = decodeString(rep);
                for (int j = 0; j < count; ++j) sb.append(decode);
            }
        }
        
        return sb.toString();
    }
}