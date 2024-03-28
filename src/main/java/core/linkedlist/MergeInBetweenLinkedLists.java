package core.linkedlist;

/**
 * LC 1669. Merge In Between Linked Lists
 */
public class MergeInBetweenLinkedLists {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode start = dummy;
        while (a > 0) {
            start = start.next;
            a--;
        }
        ListNode bn = dummy;
        while (b >= 0) {
            bn = bn.next;
            b--;
        }
        ListNode end = list2;
        while (end.next != null) {
            end = end.next;
        }
        end.next = bn.next;
        bn.next = null;
        start.next = list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(10);
        n0.next = new ListNode(1);
        n0.next.next = new ListNode(13);
        n0.next.next.next = new ListNode(6);
        n0.next.next.next.next = new ListNode(9);
        n0.next.next.next.next.next = new ListNode(5);
        ListNode n1 = new ListNode(1000000);
        n1.next = new ListNode(1000001);
        n1.next.next = new ListNode(1000002);
        ListNode res = mergeInBetween(n0, 3, 4, n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
