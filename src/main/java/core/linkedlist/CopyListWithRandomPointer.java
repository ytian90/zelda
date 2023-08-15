package core.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 138. Copy List with Random Pointer
 */
public class CopyListWithRandomPointer {
    // HashMap
    public Node copyRandomList(Node head) {
        // <old_node, new_node>
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.putIfAbsent(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
    // TS: O(N)

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node next = p.next;
            Node copy = new Node(p.val);
            p.next = copy;
            copy.next = next;
            p = next;
        }
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        Node copyHead = p.next;
        while (p != null) {
            Node copy = p.next;
            p.next = copy.next;
            p = p.next;
            copy.next = (p == null) ? null : p.next;
        }
        return copyHead;
    }
    // T: O(N)
    // S: O(1)

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
