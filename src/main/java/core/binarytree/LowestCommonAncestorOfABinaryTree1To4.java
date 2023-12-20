package core.binarytree;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 236. Lowest Common Ancestor of a Binary Tree
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * <p>
 * <p>
 * Example 1:
 * 3
 * /  \
 * 5    1
 * /  \  / \
 * 6   2 0   8
 * /\
 * 7  4
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * <p>
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 */
public class LowestCommonAncestorOfABinaryTree1To4 {
    /**
     * Q1
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /**
     * Q2, BST
     */
    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
        // not good, overflow
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }

    /**
     * Q2, node may not on tree, a node can still be descendant of itself
     */
    int count = 0;

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);
        return count == 2 ? res : null;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }

    /**
     * Q3, node has a parent node
     */
    public Node lowestCommonAncestor_3(Node p, Node q) {
        Node i = p, j = q;
        while (i != j) {
            i = (i == null) ? q : i.parent;
            j = (j == null) ? p : j.parent;
        }
        return i;
    }

    /**
     * Q4, looking for several nodes
     */
    public static TreeNode lowestCommonAncestor_4(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for (TreeNode n : nodes) {
            set.add(n.val);
        }
        return helper(root, set);
    }

    private static TreeNode helper(TreeNode root, Set<Integer> set) {
        if (root == null) return root;
        if (set.contains(root.val)) {
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        n0.left = new TreeNode(3);
        n0.right = new TreeNode(7);
        n0.left.left = new TreeNode(2);
        n0.left.right = new TreeNode(4);

        TreeNode[] input = new TreeNode[]{n0.left.left, n0.left.right, n0.right};
        System.out.println(lowestCommonAncestor_4(n0, input).val);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
