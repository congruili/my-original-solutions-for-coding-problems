/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    Queue<Character> queue = new LinkedList<>();
    boolean eof = false;
    char[] curt = new char[4];
     
    public int read(char[] buf, int n) {
        int ind = 0;
        while (ind < n && !queue.isEmpty()) buf[ind++] = queue.poll();
        if (ind == n) return ind;
        
        while (ind < n && !eof) {
            int count = read4(curt);
            for (int i = 0; i < count; ++i) queue.offer(curt[i]);
            eof = (count < 4);
            count = Math.min(count, n - ind);
            for (int i = 0; i < count; ++i) buf[ind++] = queue.poll();
        }
        
        return ind;
    }
}