// 134. LRU Cache

class Node {
    int key ,val;
    Node pre, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
    } 
}

public class LRUCache {
    /*
    * @param capacity: An integer
    */
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();        
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node curt = map.get(key);
        removeNode(curt);
        addToTail(curt);
        
        return curt.val;       
    }
    
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;    
    }
    
    private void addToTail(Node node) {
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        Node newNode = new Node(key, value);
        if (map.size() == capacity) {
            Node toBeRemoved = head.next;
            map.remove(toBeRemoved.key);
            removeNode(toBeRemoved);
        }
        
        addToTail(newNode);
        map.put(key, newNode);        
    }
}