package core.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 545. Boundary of Binary Tree
 */
public class BoundaryOfBinaryTree {
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return nodes;
        }
        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return nodes;
    }

    private void leftBoundary(TreeNode node) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }
        nodes.add(node.val);
        if (node.left != null) {
            leftBoundary(node.left);
        } else {
            leftBoundary(node.right);
        }
    }

    private void rightBoundary(TreeNode node) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }
        if (node.right != null) {
            rightBoundary(node.right);
        } else {
            rightBoundary(node.left);
        }
        nodes.add(node.val);
    }

    private void leaves(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            nodes.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
    // TS: O(N)

}
