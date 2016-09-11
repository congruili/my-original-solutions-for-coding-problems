public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.length() == 0) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        HashMap<Integer, NestedInteger> map = new HashMap<>();
        int l = 0;
        int level = 0;
        for (int r = 0; r < s.length(); ++r) {
            if (s.charAt(r) == '[') {
                level++;
                NestedInteger n = new NestedInteger();
                map.put(level, n);
                l = r + 1;
            } else if (s.charAt(r) == ']') {
                String num = s.substring(l, r);
                NestedInteger n = map.get(level);
                if (num.length() != 0) {
                    NestedInteger curt = new NestedInteger(Integer.valueOf(num));
                    n.add(curt);
                }
                
                level--;
                if (level > 0) {
                    NestedInteger prev = map.get(level);
                    prev.add(n);
                    map.put(level, prev);
                }
                l = r + 1;
            } else if (s.charAt(r) == ',') {
                String num = s.substring(l, r);
                if (num.length() != 0) {
                    NestedInteger n = map.get(level);
                    NestedInteger curt = new NestedInteger(Integer.valueOf(num));
                    n.add(curt);
                    map.put(level, n);
                }
                l = r + 1;
            }
        }
        
        return map.get(1);
    }
}