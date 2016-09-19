public class Solution {
    public int findNthDigit(int n) {
        int i = 1;
        long curt = 9;
        while(n >= curt * i) {
            n -= curt * i;
            curt *= 10;
            i++;
        }
        
        if (n == 0) return 9;
        int count = n / i;
        int remain = n % i;
        
        int begin = (int) Math.pow(10, i - 1);
        if (remain == 0) {
            int last = begin + count - 1;
            return last % 10;
        }
        
        int last = begin + count;
        return (last / (int) Math.pow(10, i - remain)) % 10;
    }
}