// 209. First Unique Character in a String

class ListNode {
    char val;
    ListNode next;
    public ListNode(char val) {
        this.val = val;
        this.next = null;
    }
}

class DataStream {
    ListNode dummy, tail;
    Set<Character> dupChars;
    Map<Character, ListNode> charToPre;
    
    public DataStream() {
        dupChars = new HashSet<>();
        charToPre = new HashMap<>();
        dummy = new ListNode('.');
        tail = dummy;
    }
    
    public void addChar(char c) {
        if (dupChars.contains(c)) {
            return;
        }
        
        if (charToPre.containsKey(c)) {        
            ListNode pre = charToPre.get(c);
            pre.next = pre.next.next;   
            dupChars.add(c);
            charToPre.remove(c);
            if (pre.next != null) {
                charToPre.put(pre.next.val, pre);
            } else {
                tail = pre;
            }
            
            return;
        } 
        
        ListNode newNode = new ListNode(c);
        tail.next = newNode;        
        charToPre.put(c, tail);
        tail = newNode;    
    }
    
    public char firstUniqueChar() {
        return dummy.next.val;
    }  

}


public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        DataStream ds = new DataStream();
        
        for (char c: str.toCharArray()) {
            ds.addChar(c);
        }
        
        return ds.firstUniqueChar();        
    }
}