package core.dfs;

import core.binarytree.TreeNode;

/**
 * LC 687. Longest Univalue Path
 */
public class LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root, -1);
        return max;
    }

    private int dfs(TreeNode node, int parent) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        max = Math.max(max, left + right);
        if (node.val == parent) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
    // TS: O(N)
}
