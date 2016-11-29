/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> used = new HashSet<>();
        queue.offer(node);
        used.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curt = queue.poll();
            map.put(curt, new UndirectedGraphNode(curt.label));
            for (UndirectedGraphNode next: curt.neighbors) {
                if (!used.contains(next)) {
                    queue.offer(next);
                    used.add(next);
                }
            }
        }
        
        used.clear();
        queue.offer(node);
        used.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curt = queue.poll();
            
            for (UndirectedGraphNode next: curt.neighbors) {
                map.get(curt).neighbors.add(map.get(next));
                if (!used.contains(next)) {
                    queue.offer(next);
                    used.add(next);
                }
            }
        }
        
        return map.get(node);

    }
}