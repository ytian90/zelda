package core.linkedlist;

/**
 * LC 92. Reverse Linked List II
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode second = start.next;
        for (int i = 0; i < right - left; i++) {
            start.next = second.next;
            second.next = prev.next;
            prev.next = second;
            second = start.next;
        }
        return dummy.next;
    }
    // T: O(N)
    // S: O(1)
}
