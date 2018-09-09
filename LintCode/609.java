public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        int rst = 0;
        
        for (int i = 0; i < len - 1; ++i) {
            int right = len - 1;
            while (right > i && nums[i] + nums[right] > target) {
                right--;
            }
            
            rst += (right - i);
        }
        
        return rst;
    }
}