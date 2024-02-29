package core.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 513. Find Bottom Left Tree Value
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curr = root;
        q.add(curr);
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
        }
        return curr.val;
    }
    // TS: O(N)

    private int maxDepth;
    private int res;

    public int findBottomLeftValue2(TreeNode root) {
        this.maxDepth = -1;
        this.res = 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            res = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
    // TS: O(N)
}
