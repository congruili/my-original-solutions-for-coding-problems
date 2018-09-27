// 653. Expression Add Operators

public class Solution {
    /**
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        // write your code here
        List<String> rst = new ArrayList<>();
        
        dfs(num, target, 0, "", 0, 0, rst);
        return rst;
    }
    
    private void dfs(String num, int target, int ind, String curt, long sum, long lastF, List<String> rst) {
        if (ind == num.length()) {
            if (target == sum) {
                rst.add(curt);
            }
            
            return;
        }
        
        for (int i = ind; i < num.length(); ++i) {
            long x = Long.parseLong(num.substring(ind, i + 1));
            
            if (ind == 0) {
                dfs(num, target, i + 1, x + "", x, x, rst);
            } else {
                dfs(num, target, i + 1, curt + "*" + x, sum - lastF + lastF * x, lastF * x, rst);
                
                dfs(num, target, i + 1, curt + "+" + x, sum + x, x, rst);
                dfs(num, target, i + 1, curt + "-" + x, sum - x, -x, rst);
            }
            
            if (x == 0) {
                break;
            }
        }
        
    }
}