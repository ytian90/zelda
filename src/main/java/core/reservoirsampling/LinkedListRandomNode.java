package core.reservoirsampling;

import core.linkedlist.ListNode;

import java.util.Random;

/**
 * LC 382. Linked List Random Node
 */
public class LinkedListRandomNode {
    private ListNode head;
    private Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode res = null;
        ListNode curr = head;
        for (int i = 1; curr != null; i++) {
            if (random.nextInt(i) == 0) {
                res = curr;
            }
            curr = curr.next;
        }
        return res.val;
    }
    // T: O(N)
    // S: O(1)
}
