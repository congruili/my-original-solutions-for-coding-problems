// 605. Sequence Reconstruction

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        
        int len = org.length;
        
        for (int i = 1; i <= len; ++i) {
            map.put(i, new HashSet<Integer>());
            degree.put(i, 0);
        }
        
        int count = 0;
        for (int[] seq: seqs) {
            if (seq == null || seq.length == 0) {
                continue;
            }
            
            count += seq.length;
            
            if (seq.length == 1) {
                if (seq[0] <= 0 || seq[0] > len) {
                    return false;
                }
            }
            
            for (int i = 1; i < seq.length; ++i) {
                int first = seq[i - 1];
                int second = seq[i];
                if (first <= 0 || first > len || second <= 0 || second > len) {
                    return false;
                }
                
                map.get(first).add(second);
            }
        }
        
        if (count < len) {
            return false;
        }
        
        for (int key: map.keySet()) {
            for (int next: map.get(key)) {
                degree.put(next, degree.get(next) + 1);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= len; ++i) {
            if (degree.get(i) == 0) {
                q.offer(i);
            }
        }
        
        int ind = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) {
                return false;
            }
            
            int curt = q.poll();
            if (curt != org[ind++]) {
                return false;
            }
            
            for (int next: map.get(curt)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) {
                    q.offer(next);
                }
            }
        }
        
        return ind == len;
    }
}