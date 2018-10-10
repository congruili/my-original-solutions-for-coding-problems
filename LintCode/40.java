// 40. Implement Queue by Two Stacks

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }     
     
    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        
        return stack1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        
        return stack1.peek();
    }
}