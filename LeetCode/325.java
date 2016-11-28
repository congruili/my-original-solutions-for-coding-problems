public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int rst = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (!map.containsKey(sum)) map.put(sum, i);
            if (map.containsKey(sum - k)) {
                rst = Math.max(rst, i - map.get(sum - k));
            }
        }
        
        return rst;
    }
}