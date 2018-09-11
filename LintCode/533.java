public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 0;
            } else if (sum > target) {
                diff = Math.min(sum - target, diff);
                right--;
            } else {
                diff = Math.min(target - sum, diff);
                left++;
            }
        }
        
        return diff;
    }
}