// 431. Connected Component in Undirected Graph

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return rst;
        }
        
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        for (UndirectedGraphNode n: nodes) {
            visited.put(n, false);
        }
        
        for (UndirectedGraphNode n: nodes) {
            if (!visited.get(n)) {
                bfs(n, visited, rst);
            }
        }
        
        return rst;
    }
    
    private void bfs(UndirectedGraphNode n, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> rst) {
        List<Integer> list = new ArrayList<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(n);
        list.add(n.label);
        visited.put(n, true);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode curt = q.poll();
            for (UndirectedGraphNode next: curt.neighbors) {
                if (visited.get(next)) {
                    continue;
                }
                
                visited.put(next, true);
                q.offer(next);
                list.add(next.label);
            }
        }
        
        Collections.sort(list);
        rst.add(list);
        
    }
}