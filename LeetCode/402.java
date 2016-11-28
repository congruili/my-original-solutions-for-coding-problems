public class Solution {
    public String removeKdigits(String num, int k) {
        char[] nums = num.toCharArray();
        int len = nums.length;
        if (k == len) return "0";
        int count = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len; ++i) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && count < k) {
                stack.pop();
                count++;
            }
            stack.push(nums[i]);
        }
        
        while(stack.size() > len - k) stack.pop();
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}