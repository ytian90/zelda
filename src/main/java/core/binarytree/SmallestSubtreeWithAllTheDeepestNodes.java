package core.binarytree;

/**
 * LC 865. Smallest Subtree with all the Deepest Nodes
 * same as LC 1123. Lowest Common Ancestor of Deepest Leaves
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    class Pair{
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }

    private Pair getLca(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }
        Pair left = getLca(root.left, depth + 1);
        Pair right = getLca(root.right, depth + 1);
        if (left.depth == right.depth) {
            return new Pair(root, left.depth);
        } else {
            return left.depth > right.depth ? left : right;
        }
    }
    // T: O(N)
    // S: O(H)

}
