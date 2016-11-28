public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; ++i) roots[i] = i;
        int count = n;
        
        for (int[] edge: edges) {
            int r1 = find(roots, edge[0]);
            int r2 = find(roots, edge[1]);
            
            if (r1 != r2) {
                count--;
                roots[r1] = r2;
            }
        }
        
        return count;
    }
    
    public int find(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        
        return id;
    }
}