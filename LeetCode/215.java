public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return helper(nums, 0, len - 1, len - k);
    }
    
    public int helper(int[] nums, int begin, int end, int k) {
        if (begin == end) return nums[begin];
        int pivot = nums[end];
        int left = begin;
        
        for (int i = begin; i < end; ++i) {
            if (nums[i] < pivot) swap(nums, left++, i);
        }
        
        swap(nums, left, end);
        
        if (left == k) return nums[left];
        else if (left < k) return helper(nums, left + 1, end, k);
        return helper(nums, begin, left - 1, k);
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}