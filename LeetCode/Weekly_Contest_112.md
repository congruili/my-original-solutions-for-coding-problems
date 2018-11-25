## 945. Minimum Increment to Make Array Unique
<pre>
class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        
        int rst = 0;
        Arrays.sort(A);
        
        for (int i = 1; i < A.length; ++i) {
            if (A[i] <= A[i - 1]) {
                int newNum = A[i - 1] + 1; 
                rst += newNum - A[i];
                A[i] = newNum;
            }      
        }
        
        return rst;        
    }
}
</pre>

## 946. Validate Stack Sequences
<pre>
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            if (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j ++;
            } else {
                stack.push(pushed[i]);
                i ++;
            }        
        }
        
        while (j < len) {
            if (stack.isEmpty() || popped[j] != stack.peek()) {
                return false;
            } else {
                stack.pop();
                j ++;
            }                    
        }
        
        return true;    
    }
}
</pre>

## 948. Bag of Tokens
<pre>
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (P == 0 || tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Arrays.sort(tokens);
        int len = tokens.length;
        int l = 0, r = len - 1;
        int points = 0;
        int rst = 0;
        
        while (l <= r) {
            if (P >= tokens[l]) {
                P -= tokens[l];
                l ++;
                points ++;
                rst = Math.max(rst, points);                            
            } else if (points > 0) {
                P += tokens[r];
                r --;
                points --;            
            } else {
                break;
            }
        }
        
        return rst;        
    }
}
</pre>
