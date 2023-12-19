package core.binarytree.bst;

import core.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 938. Range Sum of BST
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }

    private int helper(TreeNode node, int lo, int hi) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, lo, hi);
        int right = helper(node.right, lo, hi);
        if (lo <= node.val && node.val <= hi) {
            return left + node.val + right;
        } else if (node.val < lo) {
            return right;
        } else {
            return left;
        }
    }
    // TS: O(N)

    public int rangeSumBST2(TreeNode root, int low, int high) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (low <= curr.val && curr.val <= high) {
                res += curr.val;
            }
            if (curr.left != null && low < curr.val) {
                stack.push(curr.left);
            }
            if (curr.right != null && curr.val < high) {
                stack.push(curr.right);
            }
        }
        return res;
    }
    // TS: O(N)

}
