public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (cand == null || cand.length == 0) return rst;
        Arrays.sort(cand);
        
        List<Integer> nums = new ArrayList<>();
        
        nums.add(cand[0]);
        for (int i = 1; i < cand.length; ++i) {
            if (cand[i] != cand[i - 1]) nums.add(cand[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        helper(0, target, nums, list, rst);
        
        return rst;
    }
    
    public void helper(int ind, int curt, List<Integer> nums, List<Integer> list, List<List<Integer>> rst) {
        if (curt == 0) {
            rst.add(new ArrayList<Integer>(list));
        }
        
        if (ind == nums.size()) return;
        
        for (int i = ind; i < nums.size(); ++i) {
            if (nums.get(i) <= curt) {
                list.add(nums.get(i));
                helper(i, curt - nums.get(i), nums, list, rst);
                list.remove(list.size() - 1);
            }
        }
    }
}