package stack;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack();
        output = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        this.mvInputToOutput();
        return output.pop();
    }

    private void mvInputToOutput() {
        if (output.isEmpty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        this.mvInputToOutput();
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return output.empty() && input.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        System.out.println("queue.empty:" + queue.empty());
        int param1 = queue.peek();
        System.out.println("param1:" + param1 + ", queue.empty:" + queue.empty());
        int param2 = queue.pop();
        System.out.println("param1:" + param1 + ", param2:" + param2 + ", queue.empty:" + queue.empty());
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */