// 526. Load Balancer

public class LoadBalancer {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;
    
    public LoadBalancer() {
        // do intialization if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        if (map.containsKey(server_id)) {
            return;
        }
        
        list.add(server_id);
        map.put(server_id, list.size() - 1);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        if (!map.containsKey(server_id)) {
            return;
        }
        
        int ind = map.get(server_id);
        int last_id = list.get(list.size() - 1);
        map.remove(server_id);
        map.put(last_id, ind);
        
        list.set(ind, last_id);
        list.remove(list.size() - 1);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return list.get(rand.nextInt(list.size()));
    }
}