package core.linkedlist;

/**
 * LC 708. Insert into a Sorted Circular Linked List
 */
public class InsertIntoASortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node[] nodes = process(head);
        Node first = nodes[0], last = nodes[1];
        if (insertVal <= first.val || insertVal >= last.val) {
            last.next = new Node(insertVal);
            last.next.next = first;
        } else {
            while (first.next.val < insertVal) {
                first = first.next;
            }
            Node t = first.next;
            first.next = new Node(insertVal);
            first.next.next = t;
        }
        return head;
    }

    private Node[] process(Node head) {
        Node curr = head;
        while (curr.next.val >= curr.val && curr.next != head) {
            curr = curr.next;
        }
        return new Node[]{curr.next, curr};
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        InsertIntoASortedCircularLinkedList obj = new InsertIntoASortedCircularLinkedList();
        Node n0 = new Node(3);
        n0.next = new Node(3);
        n0.next.next = new Node(5);
        n0.next.next.next = n0;

        Node res = obj.insert(n0, 0);
        int i = 4;
        while (i >= 0) {
            System.out.println(res.val);
            res = res.next;
            i--;
        }
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

}
