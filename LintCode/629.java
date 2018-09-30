// 629. Minimum Spanning Tree

/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    Map<String, String> father; 
     
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> rst = new ArrayList<Connection>();
        
        if (connections == null || connections.size() == 0) {
            return rst;
        }
        
        Comparator<Connection> comp = new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost) {
                    return a.cost - b.cost;
                }
                
                if (!a.city1.equals(b.city1)) {
                    return a.city1.compareTo(b.city1);
                }
                
                return a.city2.compareTo(b.city2);
            }
        };
        
        Collections.sort(connections, comp);
        
        father = new HashMap<>(); 
        
        for (Connection c: connections) {
            father.put(c.city1, c.city1);
            father.put(c.city2, c.city2);
        }
        
        int count = father.keySet().size();
        
        for (Connection c: connections) {
            String father1 = find(c.city1);
            String father2 = find(c.city2);
            
            if (father1.equals(father2)) {
                continue;
            }
            
            union(father1, father2);
            rst.add(c);
            count--;
        }
        
        if (count == 1) {
            return rst;
        }
        
        return new ArrayList<Connection>();
    }
    
    private String find(String city) {
        List<String> list = new ArrayList<>();
        while (!father.get(city).equals(city)) {
            list.add(city);
            city = father.get(city);
        }
        
        for (String s: list) {
            father.put(s, city);
        }
        
        return city;
    }
    
    private void union(String city1, String city2) {
        String father1 = find(city1);
        String father2 = find(city2);
        
        if (!father1.equals(father2)) {
            father.put(father1, father2);
        }
    }
    
}