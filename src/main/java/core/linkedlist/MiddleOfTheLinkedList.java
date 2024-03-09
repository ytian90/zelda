package core.linkedlist;

/**
 * LC 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // T: O(N)
    // S: O(1)
}
