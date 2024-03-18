package core.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1171. Remove Zero Sum Consecutive Nodes from Linked List
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        int preSum = 0;
        for (ListNode i = dummy; i != null ; i = i.next) {
            preSum += i.val;
            map.put(preSum, i);
        }
        preSum = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            preSum += i.val;
            i.next = map.get(preSum).next;
        }
        return dummy.next;
    }
    // TS: O(N)
}
