// http://www.cnblogs.com/grandyang/p/5735205.html

public class PhoneDirectory {

    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    Queue<Integer> queue;
    HashSet<Integer> set;
    
    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        for (int i = 0; i < maxNumbers; ++i) {
            queue.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!queue.isEmpty())  {
            int curt = queue.poll();
            set.add(curt);
            return curt;
        }
        return -1;        
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);        
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) {
            set.remove(number);
            queue.offer(number);
        }        
    }
}


/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */