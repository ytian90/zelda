package core.binarytree;

/**
 * LC 124. Binary Search Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    // return maximum length it can get pass node
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        res = Math.max(res, left + node.val + right);
        return node.val + Math.max(left, right);
    }
    // TS: O(N)
}
