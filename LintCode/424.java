// 424. Evaluate Reverse Polish Notation

public class Solution {
    /**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
        // write your code here
        int rst = 0;
        if (tokens == null || tokens.length == 0) {
            return rst;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (String s: tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                int curt = 0;
                if (s.equals("+")) {
                    curt = first + second;
                } else if (s.equals("-")) {
                    curt = first - second;
                } else if (s.equals("*")) {
                    curt = first * second;
                } else {
                    curt = first / second;
                }
                stack.push(curt);
            } else {
                int curt = Integer.parseInt(s);
                stack.push(curt);
            }
        }
        
        return stack.pop();
    }
}