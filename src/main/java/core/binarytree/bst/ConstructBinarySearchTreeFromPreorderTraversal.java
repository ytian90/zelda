package core.binarytree.bst;

import core.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 1008. Construct Binary Search Tree from Preorder Traversal
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    int i;

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] nums, int bound) {
        if (i == nums.length || nums[i] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(nums[i++]);
        node.left = helper(nums, node.val);
        node.right = helper(nums, bound);
        return node;
    }
    // TS: O(N)

    // stack
    public TreeNode bstFromPreorder2(int[] preorder) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }
    // TS: O(N)

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal o = new ConstructBinarySearchTreeFromPreorderTraversal();
        System.out.println(o.bstFromPreorder(new int[]{8,5,1,7,10,12}));
        System.out.println(o.bstFromPreorder(new int[]{1,3}));
    }
}
