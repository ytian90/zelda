package core.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 143. Reorder List
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = fast;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (slow != null) {
            ListNode t = slow.next;
            slow.next = null;
            stack.push(slow);
            slow = t;
        }
        ListNode p = head;
        while (!stack.isEmpty()) {
            ListNode t = p.next;
            p.next = stack.pop();
            p.next.next = t;
            p = t;
        }
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        n0.next = new ListNode(2);
        n0.next.next = new ListNode(3);
        n0.next.next.next = new ListNode(4);
        n0.next.next.next.next = new ListNode(5);
        reorderList(n0);
        while (n0 != null) {
            System.out.println(n0.val);
            n0 = n0.next;
        }
    }
}
