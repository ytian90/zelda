package core.binarytree;

/**
 * LC 112. Path Sum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (node.val + sum == targetSum) {
                return true;
            }
            return false;
        }
        boolean res = helper(node.left, targetSum, sum + node.val) || helper(node.right, targetSum, sum + node.val);
        return res;
    }
    // TS: O(N)
}
