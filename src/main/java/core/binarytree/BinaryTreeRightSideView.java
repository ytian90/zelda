package core.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    res.add(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(L), where L is the tree diameter

    // DFS Recursive
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int level, List<Integer> res) {
        if (level == res.size()) {
            res.add(node.val);
        }
        if (node.right != null) {
            helper(node.right, level + 1, res);
        }
        if (node.left != null) {
            helper(node.left, level + 1, res);
        }
    }
    // T: O(N)
    // S: O(H), where H is tree height, worst H == N
}
