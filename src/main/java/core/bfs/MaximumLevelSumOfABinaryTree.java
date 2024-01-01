package core.bfs;

import core.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1161. Maximum Level Sum of a Binary Tree
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1, maxTotal = root.val, level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size(), total = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                total += curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (total > maxTotal) {
                res = level;
                maxTotal = total;
            }
            level++;
        }
        return res;
    }
    // TS: O(N)
}
