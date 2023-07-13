package core.binarytree;

/**
 * LC 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preIndex, int[] inorder, int inStart, int inEnd) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);
        int index = findIndex(inorder, preorder[preIndex]);
        node.left = build(preorder, preIndex + 1, inorder, inStart, index - 1);
        node.right = build(preorder, preIndex + index - inStart + 1, inorder, index + 1, inEnd);
        return node;
    }

    private int findIndex(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // optimize: use map to cache inorder, key is node val, value is index
    // TS: O(N)
}
