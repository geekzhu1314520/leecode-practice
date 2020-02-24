package linkedlist;

/**
 * 翻转链表
 */
public class ReverseLinkedList01 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;

    }

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList01 linkedList = new ReverseLinkedList01();
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