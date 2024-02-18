package core.binarytree.bst;

import core.binarytree.TreeNode;

/**
 * LC 530. Minimum Absolute Difference in BST
 */
public class MinimumAbsoluteDifferenceInBST {
    int diff = Integer.MAX_VALUE;
    int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return diff;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != -1 && node.val - prev < diff) {
            diff = node.val - prev;
        }
        prev = node.val;
        inorder(node.right);
    }
    // TS: O(N)

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(543);
        n0.left = new TreeNode(384);
        n0.right = new TreeNode(652);
        n0.left.right = new TreeNode(445);
        n0.right.right = new TreeNode(699);
        MinimumAbsoluteDifferenceInBST o = new MinimumAbsoluteDifferenceInBST();
        System.out.println(o.getMinimumDifference(n0));
    }

}
