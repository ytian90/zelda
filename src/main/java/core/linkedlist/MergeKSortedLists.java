package core.linkedlist;

import java.util.PriorityQueue;

/**
 * LC 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {
    // PriorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }
        while (!pq.isEmpty()) {
            ListNode p = pq.poll();
            curr.next = p;
            curr = curr.next;
            if (p.next != null) {
                pq.add(p.next);
            }
        }
        return dummy.next;
    }
    // T: O(N + logK), where N is node number and K is the number of linked lists
    // S: O(N + K)

    // Divide and Conquer + merge 2 lists
    public ListNode mergeKLists2(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode left = partition(lists, lo, mid);
        ListNode right = partition(lists, mid + 1, hi);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p = list1, q = list2, curr = dummy;
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
        if (p != null) {
            curr.next = p;
        }
        if (q != null) {
            curr.next = q;
        }
        return dummy.next;
    }
    // T: O(N * logK)
    // S: O(1)
}
