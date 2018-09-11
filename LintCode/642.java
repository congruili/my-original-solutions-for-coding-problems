public class MovingAverage {
    /*
    * @param size: An integer
    */
    private int size;
    private double sum;
    private Queue<Integer> q;
    
    public MovingAverage(int size) {
        // do intialization if necessary
        this.size = size;
        q = new LinkedList<>();
        sum = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        sum += val;
        if (q.size() == size) {
            sum -= q.poll();
        }
        
        q.offer(val);
        
        return sum / q.size();
    }
}