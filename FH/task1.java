// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, String S) {
        // write your code in Java SE 8
        if (S == null || S.length() == 0) return N * 3;
        if (N == 0) return 0;
        String[] used = S.split(" ");
        HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
        for (String s: used) {
            int len = s.length();
            String col = s.substring(len - 1);
            int row = Integer.parseInt(s.substring(0, len - 1));
            if (!map.containsKey(row)) map.put(row, new HashSet<String>());
            map.get(row).add(col);
        }
        
        int rst = N * 3;        
        for (int i = 1; i <= N; ++i) {
            if (!map.containsKey(i)) continue;
            else rst -= taken(map.get(i));
        }
        
        return rst;        
    }
    
    public int taken(HashSet<String> set) {
        int rst = 0;
        if (set.contains("A") || set.contains("B") || set.contains("C")) rst++;
        if (set.contains("H") || set.contains("J") || set.contains("K")) rst++;
        if (set.contains("E") || set.contains("F") || (set.contains("D") && set.contains("G"))) rst++;
        return rst;                            
    }
}