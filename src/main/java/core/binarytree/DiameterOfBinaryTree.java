package core.binarytree;

/**
 * LC 543. Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
    // TS: O(N)
}
