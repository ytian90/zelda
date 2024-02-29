package core.bfs;

import core.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1609. Even Odd Tree
 */
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean evenLevel = level % 2 == 0;
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (evenLevel) {
                    if (curr.val % 2 == 0 || prev >= curr.val) {
                        return false;
                    }
                } else {
                    if (curr.val % 2 == 1 || prev <= curr.val) {
                        return false;
                    }
                }
                prev = curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            level++;
        }
        return true;
    }
    // TS: O(N)
}
