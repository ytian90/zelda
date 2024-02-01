package core.binarytree;

/**
 * LC 968. Binary Tree Cameras
 */
public class BinaryTreeCameras {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        int ret = helper(root);
        return ret == 0 ? res + 1 : res;
    }

    // return 0 if it's a leaf
    // return 1 if it's a prent of a leaf with a camera on current node
    // return 2 if it's covered without a camera on current node
    private int helper(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
    // T: O(N)
    // S: O(H), H = N
}
