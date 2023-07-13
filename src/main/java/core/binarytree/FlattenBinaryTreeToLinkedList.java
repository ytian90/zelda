package core.binarytree;

/**
 * LC 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreeToLinkedList {
    // recursive
    private static TreeNode prev = null;
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    // TS: O(N)

    // iterative
    public static void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightMost = node.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        n0.left = new TreeNode(2);
        n0.right = new TreeNode(5);
        n0.left.left = new TreeNode(3);
        n0.left.right = new TreeNode(4);
        n0.right.right = new TreeNode(6);

        flatten2(n0);
    }

}
