import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {   
  
  static class Node {
    int val, p;
    public Node(int val, int p) {
      this.val = val;
      this.p = p;
    }  
  }
  
  public static void main(String[] args) {
    List<Node> nodes = new ArrayList<>();
    nodes.add(new Node(1, 10));
    nodes.add(new Node(2, 20));
    nodes.add(new Node(3, 30));
    nodes.add(new Node(10, 200));
    nodes.add(new Node(20, 100));
    
    List<Node> list = sort(nodes);
        
    for (Node n: list) {
      System.out.print(n.val);
      System.out.print(" ");
      System.out.print(n.p);
      System.out.println();
    }
  }
  
  
  
  public static List<Node> sort(List<Node> nodes){
    List<Node> rst = new ArrayList<Node>();
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Node> set = new HashSet<>();
    HashMap<Integer, Node> nodeVal = new HashMap<>();
    
    for (Node n: nodes) {
      set.add(n);
      nodeVal.put(n.p, n);
      
      if (!map.containsKey(n.val)) map.put(n.val, 0);
      map.put(n.val, map.get(n.val) + 1);    
    }
    
    Comparator<Node> comp = new Comparator<Node>() {
      public int compare(Node a, Node b) {
        return a.val - b.val;
      }    
    };
    
    Queue<Node> queue = new LinkedList<Node>();
    
    for (Node n: set) {
      if (!map.containsKey(n.p)) queue.offer(n);
    }
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Node> curtList = new ArrayList<Node>();
      for (int k = 0; k < size; ++k) {
        Node curt = queue.poll();
        curtList.add(curt);
        if (map.containsKey(curt.val)) {
          map.put(curt.val, map.get(curt.val) - 1);
          if (map.get(curt.val) == 0) {
            map.remove(curt.val);
            if (nodeVal.containsKey(curt.val)) queue.offer(nodeVal.get(curt.val));
          }
        }
      }
        
      Collections.sort(curtList, comp);
      rst.addAll(curtList);       
        
    }
    
    return rst;   
  }

  
}  
