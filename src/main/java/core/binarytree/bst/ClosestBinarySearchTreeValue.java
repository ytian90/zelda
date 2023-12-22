package core.binarytree.bst;

import core.binarytree.TreeNode;

/**
 * LC 270. Closest Binary Search Tree Value
 */
public class ClosestBinarySearchTreeValue {
    // inorder + linear search
    int min = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        inorder(root, target);
        return min;
    }

    private void inorder(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        inorder(node.left, target);
        if (Math.abs(node.val - target) < Math.abs(min - target)) {
            min = node.val;
        } else {
            return;
        }
        inorder(node.right, target);
    }
    // TS: O(N)

    // iterative + binary search
    public int closestValue2(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target) ||
                    Math.abs(root.val - target) == Math.abs(res - target) && root.val < res) { // if same diff, choose smaller one
                res = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return res;
    }
    // T: O(H)
    // S: O(1)

}
