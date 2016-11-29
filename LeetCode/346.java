public class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int sum;
    int count;
    int cap;
    
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        count = 0;
        cap = size;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        count++;
        if (count > cap) {
            sum -= queue.poll();
            count--;
        }
        
        return (double) sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */