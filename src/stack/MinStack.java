package stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> backStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        backStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (backStack.empty() || x <= backStack.peek()) {
            backStack.push(x);
        } else {
            backStack.push(backStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        backStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return backStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      // 返回 0.
        System.out.println(minStack.getMin());   // 返回 -2.
    }

}
