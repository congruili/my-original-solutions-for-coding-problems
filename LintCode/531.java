/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (s == t) return 0;
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n: graph) map.put(n.label, n);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        
        HashSet<Integer> used = new HashSet<>();
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                UndirectedGraphNode curt = queue.poll();
                used.add(curt.label);
                for (UndirectedGraphNode next: map.get(curt.label).neighbors) {
                    if (next == t) return level;
                    if (!used.contains(next.label)) queue.offer(next);
                }
            }
            
            level++;
        }
        
        return -1;
    }
}