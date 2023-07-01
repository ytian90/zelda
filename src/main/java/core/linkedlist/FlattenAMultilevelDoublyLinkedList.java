package core.linkedlist;

import java.util.Stack;

/**
 * LC 430. Flatten a Multilevel Doubly Linked List
 */
public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head, prev = null;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            if (curr.child == null) {
                prev = curr;
            } else {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                prev = curr;
                prev.child = null;
            }
            curr = curr.next;
            if (curr == null && !stack.isEmpty()) {
                Node next = stack.pop();
                prev.next = next;
                next.prev = prev;
                curr = next;
            }
        }
        return head;
    }
    // TS: O(N), where N is the total number of nodes.

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
