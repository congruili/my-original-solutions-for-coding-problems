// non-recursive
public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        long pow = (long) n;
        if (n < 0) {
            x = 1.0 / x;
            pow = -1 * (long) n;
        }
        
        double ans = 1, tmp = x;
        
        while (pow > 0) {
            if (pow % 2 == 1) {
                ans *= tmp;
            }
            
            tmp *= tmp;
            pow /= 2;
        }
        
        return ans;
    }
}


// recursive
public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        int half = n / 2;
        if (n < 0) {
            x = 1.0 / x;
            half = -half;
        }
        
        double tmp = myPow(x, half);
        
        if (n % 2 == 0) {
            return tmp * tmp;
        }
        
        return tmp * tmp * x;
    }
}