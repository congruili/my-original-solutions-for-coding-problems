// 127. Topological Sorting

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> rst = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return rst;
        }
        
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        
        for (DirectedGraphNode curt: graph) {
            if (!map.containsKey(curt)) {
                map.put(curt, 0);
            }
            
            for (DirectedGraphNode next: curt.neighbors) {
                if (!map.containsKey(next)) {
                    map.put(next, 0);
                }
                
                map.put(next, map.get(next) + 1);
            }
        }
        
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode node: map.keySet()) {
            if (map.get(node) == 0) {
                q.offer(node);
                rst.add(node);
            }
        }
        
        while (!q.isEmpty()) {
            DirectedGraphNode curt = q.poll();
            for (DirectedGraphNode next: curt.neighbors) {
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    q.offer(next);
                    rst.add(next);
                }
            }
        }
        
        return rst;
    }
}