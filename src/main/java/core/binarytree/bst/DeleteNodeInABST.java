package core.binarytree.bst;

import core.binarytree.TreeNode;

/**
 * LC 450. Delete Node in a BST
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode successor = findSuccessor(root);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode node) {
        TreeNode n = node.right;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
    // TS: O(H)
}
