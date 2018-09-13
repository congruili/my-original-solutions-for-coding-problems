// 641. Missing Ranges

public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> list = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            list.add(getRange(lower, upper));
            return list;
        }
        
        int len = nums.length;
        if (lower < nums[0]) {
            list.add(getRange(lower, nums[0] - 1));
        }
        
        for (int i = 1; i < len; ++i) {
            if (nums[i - 1] == nums[i] || nums[i] - nums[i - 1] == 1) {
                continue;
            }
            
            list.add(getRange(nums[i - 1] + 1, nums[i] - 1));
        }
        
        if (nums[len - 1] < upper) {
            list.add(getRange(nums[len - 1] + 1, upper));
        }
        
        return list;
    }
    
    private String getRange(int i, int j) {
        if (i > j) {
            return "";
        }
        
        if (i == j) {
            return i + "";
        }
        
        return i + "->" + j;
    }
}