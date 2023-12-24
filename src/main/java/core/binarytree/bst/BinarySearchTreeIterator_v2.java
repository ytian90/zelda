package core.binarytree.bst;

import core.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 173. Binary Search Tree Iterator
 */
public class BinarySearchTreeIterator_v2 {
    Deque<TreeNode> stack;

    public BinarySearchTreeIterator_v2(TreeNode root) {
        this.stack = new ArrayDeque<TreeNode>();
        leftMostInorder(root);
    }

    private void leftMostInorder(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    // TS: O(N)

    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        TreeNode node = stack.pop();
        if (node.right != null) {
            leftMostInorder(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
