package core.bit;

/**
 * LC 1290. Convert Binary Number in a Linked List to Integer
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode curr = head;
        while (curr != null) {
            res = res << 1;
            res |= curr.val;
            curr = curr.next;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
