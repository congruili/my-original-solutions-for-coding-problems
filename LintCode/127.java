/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) return rst;
        
        HashMap<DirectedGraphNode, Integer> nodes = new HashMap<>();
        
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode next: node.neighbors) {
                if (!nodes.containsKey(next)) nodes.put(next, 0);
                nodes.put(next, nodes.get(next) + 1);
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        for (DirectedGraphNode node: graph) {
            if (!nodes.containsKey(node)) queue.offer(node);
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode curt = queue.poll();
            rst.add(curt);
            for (DirectedGraphNode next: curt.neighbors) {
                if (nodes.containsKey(next)) {
                    nodes.put(next, nodes.get(next) - 1);
                    if (nodes.get(next) == 0) {
                        nodes.remove(next);
                        queue.offer(next);
                    }
                }
            }
        }
        
        return rst;
    }
}