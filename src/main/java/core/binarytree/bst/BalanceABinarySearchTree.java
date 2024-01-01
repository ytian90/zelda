package core.binarytree.bst;

import core.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1382. Balance a Binary Search Tree
 */
public class BalanceABinarySearchTree {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildBST(0, list.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }

    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = list.get(mid);
        node.left = buildBST(start, mid - 1);
        node.right = buildBST(mid + 1, end);
        return node;
    }
    // TS: O(N)
}
