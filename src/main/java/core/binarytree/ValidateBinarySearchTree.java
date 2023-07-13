package core.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    // recursive with valid range
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
    // TS: O(N)

    // recursive with in-order traversal
    private Integer prev;

    public boolean isValidBST2(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!inorder(node.left)) {
            return false;
        }
        if (prev != null && node.val <= prev) {
            return false;
        }
        prev = node.val;
        return inorder(node.right);
    }
    // TS: O(N)

    // iterative with in-order traversal
    public boolean isValidBST3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
    // TS: O(N)
}
