package core.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * LC 1206. Design Skiplist
 */
public class DesignSkiplist {
    class Node {
        int val;
        Node next, down;

        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }

    Node head;
    Random random;

    public DesignSkiplist() {
        this.head = new Node(-1, null, null);
        this.random = new Random();
    }

    public boolean search(int target) {
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < target) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == target) {
                return true;
            }
            curr = curr.down;
        }
        return false;
    }

    public void add(int num) {
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            stack.push(curr);
            curr = curr.down;
        }
        boolean insert = true;
        Node down = null;
        while (insert && !stack.isEmpty()) {
            curr = stack.pop();
            curr.next = new Node(num, curr.next, down);
            down = curr.next;
            insert = random.nextDouble() < 0.5;
        }
        if (insert) {
            head = new Node(-1, null, head);
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        boolean found = false;
        while (curr != null) {
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == num) {
                found = true;
                curr.next = curr.next.next;
            }
            curr = curr.down;
        }
        return found;
    }

    public static void main(String[] args) {
        DesignSkiplist o = new DesignSkiplist();
        o.add(1);
        o.add(2);
        o.add(3);
        o.search(0);
        o.add(4);
        o.search(1);
        o.erase(0);
        o.erase(1);
        o.search(1);
        System.out.println();
    }
}
