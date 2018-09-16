// 178. Graph Valid Tree

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return false;
        }
        
        if (edges.length != n - 1) {
            return false;
        }
        
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            map.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int curt = q.poll();
            
            for (int next: map.get(curt)) {
                if (visited.contains(next)) {
                    continue;
                }
                
                q.offer(next);
                visited.add(next);
            }
        }
        
        return visited.size() == n;
    }
}