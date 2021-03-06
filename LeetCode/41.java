// 41. First Missing Positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int len = nums.length;
        
        for (int i = 0; i < len; ++i) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > len) {
                    break;
                }
            
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
            
                swap(nums, i, nums[i] - 1);           
            }       
        }
        
        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return len + 1;       
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}