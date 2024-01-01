package core.binarytree;

/**
 * LC 1123. Lowest Common Ancestor of Deepest Leaves
 * same as LC 865. Smallest Subtree with all the Deepest Nodes
 */
public class LowestCommonAncestorOfDeepestLeaves {
    class Pair{
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
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
    // TS: O(N)

    // global deepest variable
    int deepest = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) {
            return depth;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == deepest && right == deepest) {
            lca = node;
        }
        return Math.max(left, right);
    }
    // TS: O(N)

    public static void main(String[] args) {
        LowestCommonAncestorOfDeepestLeaves o = new LowestCommonAncestorOfDeepestLeaves();
        TreeNode n0 = new TreeNode(3);
        n0.left = new TreeNode(5);
        n0.right = new TreeNode(1);
        n0.left.left = new TreeNode(6);
        n0.left.right = new TreeNode(2);
        n0.left.right.left = new TreeNode(7);
        n0.right.left = new TreeNode(0);
        n0.right.right = new TreeNode(8);

        System.out.println(o.lcaDeepestLeaves(n0).val);
    }

}
