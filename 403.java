public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i: stones) map.put(i, new HashSet<Integer>());
        
        if (map.containsKey(1)) map.get(1).add(1);
        else return false;
        
        int len = stones.length;
        
        for (int i = 1; i < len; ++i) {
            int curt = stones[i];
            HashSet<Integer> set = map.get(curt);
            
            for (int j: set) {
                int stepSize = j - 1;
                for (int k = 0; k < 3; ++k) {
                    if (stepSize != 0 && map.containsKey(curt + stepSize)) map.get(curt + stepSize).add(stepSize);
                    stepSize++;
                }
            }
        }
        
        return !map.get(stones[len - 1]).isEmpty();
    }
}