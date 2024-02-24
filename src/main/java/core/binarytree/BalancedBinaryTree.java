package core.binarytree;

/**
 * LC 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return 1 + Math.max(left, right);
    }
    // TS: O(N)
}
