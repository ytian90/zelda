package core.linkedlist;

/**
 * LC 2. Add Two Numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, dummy = new ListNode(0), curr = dummy;
        int carry = 0;
        while (p != null || q != null) {
            if (p != null) {
                carry += p.val;
                p = p.next;
            }
            if (q != null) {
                carry += q.val;
                q = q.next;
            }
            curr.next = new ListNode(carry % 10);
            carry /= 10;
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
    // Time and Space: O(N)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
