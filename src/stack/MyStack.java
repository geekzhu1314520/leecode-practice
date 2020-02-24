package stack;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class MyStack {

    private Queue<Integer> input;
    private Queue<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        input = new LinkedBlockingQueue<>();
        output = new LinkedBlockingQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        while (input.size() != 0) {
            output.add(input.poll());
        }
        input.add(x);
        while (output.size() != 0) {
            input.add(output.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return input.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return input.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return input.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);

        int param1 = stack.top();
        int param2 = stack.pop();
        int param3 = stack.pop();

        System.out.println("param1:" + param1 + ", param2:" + param2
                + ", param3:" + param3 + ", empty:" + stack.empty());

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */