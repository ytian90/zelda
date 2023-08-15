package core.linkedlist;

/**
 * LC 25. Reverse Nodes in k-Group
 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy.next;
        int count = 1;
        while (curr != null) {
            if (count == k) {
                count = 0;
                prev = reverse(prev, curr);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
            count++;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode prev, ListNode end) {
        ListNode curr = prev.next;
        while (prev.next != end) {
            ListNode t = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = t;
        }
        return curr;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        n0.next = new ListNode(2);
        n0.next.next = new ListNode(3);
        n0.next.next.next = new ListNode(4);
        n0.next.next.next.next = new ListNode(5);
        ListNode n1 = reverseKGroup(n0, 3);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

}
