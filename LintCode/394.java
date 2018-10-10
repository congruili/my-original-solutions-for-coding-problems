// 394. Coins in a Line

public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0) {
            return false;
        }
        
        if (n <= 2) {
            return true;
        }
        
        boolean[] canWin = new boolean[n];
        
        canWin[0] = true;
        canWin[1] = true;
        
        for (int i = 2; i < n; ++i) {
            if (canWin[i - 2] && canWin[i - 1]) {
                continue;
            }
            
            canWin[i] = true;
        }
        
        return canWin[n - 1];
    }
}