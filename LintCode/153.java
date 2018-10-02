// 153. Combination Sum II

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<>();
        if (num == null) {
            return rst;
        }
        
        Arrays.sort(num);
        
        dfs(num, target, 0, new ArrayList<Integer>(), rst);
        return rst;             
    }
    
    private void dfs(int[] num, int target, int ind, List<Integer> list, List<List<Integer>> rst) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(list));
            return;        
        }
        
        if (ind == num.length) {
            return;
        }
        
        for (int i = ind; i < num.length; ++i) {
            if (i != ind && num[i] == num[i - 1]) {
                continue;
            }
        
            if (num[i] > target) {
                break;
            }
            
            list.add(num[i]);
            dfs(num, target - num[i], i + 1, list, rst);
            list.remove(list.size() - 1);        
        } 
                 
    }   
}