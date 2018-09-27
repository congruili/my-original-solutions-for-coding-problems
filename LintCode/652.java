// 652. Factorization

public class Solution {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        dfs(n, 2, new ArrayList<Integer>(), rst);
        return rst;
    }
    
    private void dfs(int n, int curt, List<Integer> list, List<List<Integer>> rst) {
        list.add(n);
        if (list.size() > 1) {
            rst.add(new ArrayList<Integer>(list));
        }
        list.remove(list.size() - 1);
        
        for (int i = curt; i <= n / i; ++i) {
            if (n % i == 0) {
                list.add(i);
                dfs(n / i, i, list, rst);
                list.remove(list.size() - 1);
            }
        }
    }
}