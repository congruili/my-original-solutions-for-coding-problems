public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> rst = new ArrayList<String>();

        if (nums == null || nums.length == 0) {
            rst.add(helper(lower, upper));
            return rst;
        }

        int len = nums.length;

        if (lower < nums[0]) rst.add(helper(lower, nums[0] - 1));

        for (int i = 1; i < len; ++i) {
            if (nums[i - 1] == nums[i] || nums[i - 1] + 1 == nums[i]) continue;
            rst.add(helper(nums[i - 1] + 1, nums[i] - 1));
        }

        if (nums[len - 1] < upper) rst.add(helper(nums[len - 1] + 1, upper));
        return rst;
    }

    public String helper(int left, int right) {
        if (left == right) return left + "";
        return left + "->" + right;
    }
}