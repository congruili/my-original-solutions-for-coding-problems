// O(n) scan left ->  <- right

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
        
        int rst = 0;
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                rst += (right - left);
                left++;
            } else {
                right--;
            }
        }
        
        return rst;
    }
}