// 618. Search Graph Nodes

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if (graph == null || graph.size() == 0 || node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode curt = q.poll();
            if (values.get(curt) == target) {
                return curt;
            }
            
            for (UndirectedGraphNode next: curt.neighbors) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        
        return null;
    }
}