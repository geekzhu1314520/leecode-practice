package linkedlist;

/**
 * 翻转链表
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = pre;
            pre = current;
            current = nextNode;
        }

        return pre;
    }

    public static void main(String[] args) {
        ReverseLinkedList linkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }
        head = linkedList.reverseList(head);
    }
}