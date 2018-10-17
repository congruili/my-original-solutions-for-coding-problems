// 138. Subarray Sum

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        
        int len = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                rst.add(map.get(sum) + 1);
                rst.add(i);
                return rst; 
            } else {
                map.put(sum, i);
            }
        }
        
        return rst;      
    }
}