package core.binarytree;

/**
 * LC 236. Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
    // T/S: O(N)

    // Q2: BST
    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor_BST(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor_BST(root.left, p, q);
        } else {
            return root;
        }
    }

    // Q3: node has parent node
    public TreeNode lowestCommonAncestor_P(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode i = p, j = q;
        while (i != j) {
            i = (i == null) ? q : i.parent;
            j = (j == null) ? p : j.parent;
        }
        return i;
    }

}
