package core.binarytree;

/**
 * LC 236. Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestorOfABinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
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

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        n0.left = new TreeNode(5);
        n0.right = new TreeNode(1);
        n0.left.left = new TreeNode(6);
        n0.left.right = new TreeNode(2);
        n0.left.right.left = new TreeNode(7);
        n0.left.right.right = new TreeNode(4);
        n0.right.left = new TreeNode(0);
        n0.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(n0, n0.left.right, n0.right));
    }

}
