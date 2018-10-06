// 591. Connecting Graph III

public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    int[] father; 
    int count;
     
    public ConnectingGraph3(int n) {
        father = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            father[i] = i;
        }
        
        count = n;
    }
    
    public int find(int i) {
        List<Integer> list = new ArrayList<>();
        
        while (i != father[i]) {
            list.add(i);
            i = father[i];
        }
        
        for (int num: list) {
            father[num] = i;
        }
        
        return i;
    }
     
    public void connect(int a, int b) {
        // write your code here
        int root_a = find(a);
        int root_b = find(b);
        
        if (root_a != root_b) {
            count--;
            father[root_a] = root_b;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return count;
    }
}