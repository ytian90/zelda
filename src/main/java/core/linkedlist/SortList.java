package core.linkedlist;

/**
 * LC 148. Sort List
 */
public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstEnd = head, secondStart = head, secondEnd = head;
        while (secondEnd != null && secondEnd.next != null) {
            firstEnd = secondStart;
            secondStart = secondStart.next;
            secondEnd = secondEnd.next.next;
        }
        firstEnd.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(secondStart);
        return merge(first, second);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, p = l1, q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        if (p == null) curr.next = q;
        if (q == null) curr.next = p;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(4);
        n0.next = new ListNode(2);
        n0.next.next = new ListNode(1);
        n0.next.next.next = new ListNode(3);
        ListNode res = sortList(n0);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
