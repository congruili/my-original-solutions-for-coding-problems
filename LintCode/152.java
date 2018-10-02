// 152. Combinations

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<>();
        
        if (n == 0 || n < k) {
            return rst;
        }
        
        dfs(1, n, k, new ArrayList<Integer>(), rst);
        
        return rst;                
    }
    
    private void dfs(int ind, int n, int k, List<Integer> list, List<List<Integer>> rst) {
        if (ind > n && k > 0) {
            return;
        }
        
        if (k == 0) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = ind; i <= n; ++i) {
            list.add(i);
            dfs(i + 1, n, k - 1, list, rst);            
            list.remove(list.size() - 1);
        }
    
    }
}