package core.linkedlist;

/**
 * LC 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {
    // iterative
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while (curr != null && curr.next != null) {
            // define nodes to swap
            ListNode firstNode = curr;
            ListNode secondNode = curr.next;
            // swapping
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            // reset
            prev = firstNode;
            curr = firstNode.next;
        }
        return dummy.next;
    }
    // T: O(N)
    // S: O(1)

    // recursion
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
    // TS: O(N)
}
