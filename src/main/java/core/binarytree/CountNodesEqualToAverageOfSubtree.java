package core.binarytree;

/**
 * LC 2265. Count Nodes Equal to Average of Subtree
 */
public class CountNodesEqualToAverageOfSubtree {
    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        if (node.left == null && node.right == null) {
            res++;
            return new int[]{node.val, 1};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int val = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        if (node.val == val / count) {
            res++;
        }
        return new int[]{val, count};
    }
    // TS: O(N)
}
