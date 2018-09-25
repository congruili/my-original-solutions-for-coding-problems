// 1324. Count Primes

public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; ++j) {
                    notPrime[i * j] = true;
                }
            }
        }
        
        return count;
    }
}