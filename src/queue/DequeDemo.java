package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);

        while (!deque.isEmpty()){
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
