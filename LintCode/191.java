// 191. Maximum Product Subarray

public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        int rst = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            rst = Math.max(rst, max[i]);         
        }
        
        return rst;        
    }
}