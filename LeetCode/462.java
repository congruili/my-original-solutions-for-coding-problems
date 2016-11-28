public class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int k = (len - 1) / 2;
        int mid = find(nums, 0, len - 1, k);
        int rst = 0;
        for (int i: nums) rst += Math.abs(i - mid);
        return rst;
    }
    
    public int find(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; ++i) {
            if (nums[i] < pivot) swap(nums, left++, i);
        }
        
        swap(nums, left, end);
        if (left == k) return nums[left];
        else if (left < k) return find(nums, left + 1, end, k);
        return find(nums, start, left - 1, k);
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}