// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] T) {
        // write your code in Java SE 8
        if (T == null || T.length == 0) return new int[0];
        int M = T.length;
        int capital = -1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; ++i) map.put(i, new HashSet<Integer>());        
        for (int i = 0; i < M; ++i) {
            if (T[i] == i) capital = i;
            else {
                map.get(i).add(T[i]);
                map.get(T[i]).add(i);   
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(capital);
        
        List<Integer> count = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count.add(size);
            for (int i = 0; i < size; ++i) {
                int curt = queue.poll();
                for (int next: map.get(curt)) {
                    map.get(next).remove(curt);
                    queue.offer(next);
                }
            }            
        }
        
        int[] rst = new int[M - 1];
        
        for (int i = 1; i < count.size(); ++i) rst[i - 1] = count.get(i);
        
        return rst;        
    }
}