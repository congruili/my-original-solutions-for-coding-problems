// 135. Combination Sum

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] cands, int target) {
        // write your code here        
        List<List<Integer>> rst = new ArrayList<>();
        if (cands == null) {
            return rst;
        }
        
        Arrays.sort(cands);
        dfs(cands, target, 0, new ArrayList<Integer>(), rst);
        
        return rst;        
    }
    
    private void dfs(int[] cands, int target, int ind, List<Integer> list, List<List<Integer>> rst) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (ind == cands.length) {
            return;
        }
        
        for (int i = ind; i < cands.length; ++i) {
            if (i != 0 && cands[i] == cands[i - 1]) {
                continue;
            }
            
            if (cands[i] > target) {
                break;
            }
            
            list.add(cands[i]);
            dfs(cands, target - cands[i], i, list, rst);
            list.remove(list.size() - 1);            
        }
    }
}