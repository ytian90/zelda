package core.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 226. Invert Binary Tree
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        invert(node.left);
        invert(node.right);
        return node;
    }
    // TS: O(N)

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode t = curr.left;
            curr.left = curr.right;
            curr.right = t;
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return root;
    }
    // TS: O(N)
}
