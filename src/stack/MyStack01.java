package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class MyStack01 {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack01() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack01 stack = new MyStack01();
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