package deque;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(5);
        queue.add(10);
        queue.add(7);
        queue.add(9);
        queue.add(15);
        queue.add(11);
        queue.add(13);
        queue.add(20);
        queue.add(12);

        queue.add(4);

        queue.remove(9);
    }

}
