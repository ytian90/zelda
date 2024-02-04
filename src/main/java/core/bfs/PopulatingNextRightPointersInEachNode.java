package core.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersInEachNode {
    // bfs
    public static Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                curr.next = prev;
                prev = curr;
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
        }
        return root;
    }
    // TS: O(N)

    // dfs
    public static Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
    // TS: O(N)

    public static void main(String[] args) {
        Node n0 = new Node(1);
        n0.left = new Node(2);
        n0.right = new Node(3);
        n0.left.left = new Node(4);
        n0.left.right = new Node(5);
        n0.right.left = new Node(6);
        n0.right.right = new Node(7);

        Node res = connect(n0);
        System.out.println();
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
