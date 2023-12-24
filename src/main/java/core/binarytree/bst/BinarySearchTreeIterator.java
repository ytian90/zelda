package core.binarytree.bst;

import core.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 173. Binary Search Tree Iterator
 */
public class BinarySearchTreeIterator {
    Queue<TreeNode> q;

    public BinarySearchTreeIterator(TreeNode root) {
        this.q = new LinkedList<>();
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        q.add(node);
        inorder(node.right);
    }
    // TS: O(N)

    public int next() {
        if (hasNext() && q.peek() != null) {
            return q.poll().val;
        }
        return -1;
    }
    // TS: O(1)

    public boolean hasNext() {
        return !q.isEmpty();
    }
    // TS: O(1)
}
