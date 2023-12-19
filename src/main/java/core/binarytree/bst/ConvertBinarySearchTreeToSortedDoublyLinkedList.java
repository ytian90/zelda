package core.binarytree.bst;

/**
 * LC 426. Convert Binary Search Tree to Sorted Doubly Linked List
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void inorder(Node curr) {
        if (curr == null) {
            return;
        }
        inorder(curr.left);
        if (last == null) {
            first = curr;
        } else {
            last.right = curr;
            curr.left = last;
        }
        last = curr;
        inorder(curr.right);
    }
    // TS: O(N)


    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
