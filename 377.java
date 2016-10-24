public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target + 1];
        count[0] = 1;
        for (int i = 0; i <= target; ++i) {
            if (count[i] != 0) {
                for (int j = 0; j < nums.length; ++j) {
                    if (i + nums[j] <= target) count[i + nums[j]] += count[i];
                }
            }
        }
        
        return count[target];
    }
}