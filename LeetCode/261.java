public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int len = edges.length;
        if (len != n - 1) return false;
        
        int[] roots = new int[n];
        for (int i = 0; i < n; ++i) roots[i] = i;
        
        for (int[] edge: edges) {
            int r1 = find(roots, edge[0]);
            int r2 = find(roots, edge[1]);
            
            if (r1 == r2) return false;
            roots[r1] = r2;
        }
        
        return true;
    }
    
    public int find(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        
        return id;
    }
}