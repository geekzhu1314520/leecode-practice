package lru;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private int capacity;
    private int size;
    private DLinkedList dLinkedList;
    private HashMap<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dLinkedList = new DLinkedList();
        this.size = 0;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            dLinkedList.moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            dLinkedList.moveToHead(node);
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            dLinkedList.addNode(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode oldNode = dLinkedList.popTail();
                cache.remove(oldNode.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

class DLinkedList {

    private DLinkedNode head;
    private DLinkedNode tail;

    public DLinkedList() {
        head = new DLinkedNode(0);
        tail = new DLinkedNode(0);
        head.next = tail;
        tail.pre = head;
    }

    public void addNode(DLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public DLinkedNode popTail() {
        DLinkedNode tailNode = tail.pre;
        if (tailNode != head) {
            this.removeNode(tail.pre);
        }
        return tailNode;
    }
}

class DLinkedNode {
    int key;
    int val;
    DLinkedNode pre;
    DLinkedNode next;

    public DLinkedNode(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
    }

    public DLinkedNode(int key, int val) {
        this(val);
        this.key = key;
    }
}

