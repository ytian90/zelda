package core.linkedlist;

/**
 * LC 19. Remove Nth Node from end of List
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode q = dummy;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        ListNode p = dummy;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
    // T: O(N)
    // S: O(1)
}
