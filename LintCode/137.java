// 137. Clone Graph

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        Set<Integer> used = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        
        q.offer(node);
        used.add(node.label);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode curt = q.poll();
            map.put(curt, new UndirectedGraphNode(curt.label));
            
            for (UndirectedGraphNode next: curt.neighbors) {
                if (!used.contains(next.label)) {
                    q.offer(next);
                    used.add(next.label);
                }
            }
        }
        
        q.clear();
        used.clear();
        
        q.offer(node);
        used.add(node.label);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode curt = q.poll();

            for (UndirectedGraphNode next: curt.neighbors) {
                map.get(curt).neighbors.add(map.get(next));
                
                if (!used.contains(next.label)) {
                    q.offer(next);
                    used.add(next.label);
                }
            }
        }
        
        return map.get(node);
    }
    
}