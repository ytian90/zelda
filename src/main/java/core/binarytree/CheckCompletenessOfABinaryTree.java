package core.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 958. Check Completeness of a Binary Tree
 */
public class CheckCompletenessOfABinaryTree {
    // bfs
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean nullNodeFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                nullNodeFound = true;
            } else {
                if (nullNodeFound) {
                    return false;
                }
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
    // TS: O(N)

    // dfs
    public boolean isCompleteTree2(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private boolean dfs(TreeNode node, int index, int n) {
        if (node == null) {
            return true;
        }
        if (index >= n) {
            return false;
        }
        return dfs(node.left, 2 * index + 1, n) && dfs(node.right, 2 * index + 2, n);
    }
    // TS: O(N)
    /*
                            0
                       1         2
                   3      4   5     6
                7     8
        left: 2 * index + 1
        right: 2 * index + 2
     */

}
