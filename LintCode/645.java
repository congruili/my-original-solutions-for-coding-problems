// 645. Find the Celebrity

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int cand = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(cand, i)) {
                cand = i;
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (i == cand) {
                continue;
            }
            
            if (knows(cand, i) || !knows(i, cand)) {
                return -1;
            }
        }
        
        return cand;
    }
}