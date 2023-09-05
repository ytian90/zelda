package core.linkedlist;

/**
 * LC 160. Intersection of Two Linked Lists
 */
public class IntersectionOfTwoLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
    // T: O(N), where N is the total number of nodes in 2 lists
    // S: O(1)

    public static void main(String[] args) {
        ListNode n0 = new ListNode(2);
        n0.next = new ListNode(6);
        n0.next.next = new ListNode(4);
        ListNode n1 = new ListNode (1);
        n1.next = new ListNode(5);
        System.out.println(getIntersectionNode(n0, n1));
    }

}
