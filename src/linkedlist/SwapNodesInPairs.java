package linkedlist;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode self = new ListNode(0);
        ListNode pre = self;
        pre.next = head;

        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = pre.next.next;
            a.next = b.next;
            b.next = a;
            pre.next = b;
            pre = a;
        }

        return self.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;

        for (int i = 2; i <= 4; i++) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }

        SwapNodesInPairs pairs = new SwapNodesInPairs();
        ListNode node1 = pairs.swapPairs(head);
    }

}
