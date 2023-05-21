package core.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    // BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (flag) {
                    list.add(curr.val);
                } else {
                    list.addFirst(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
    // T/S: O(N)

    // DFS
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (level == res.size()) {
            res.add(new LinkedList<>());
        }
        List<Integer> list = res.get(level);
        if (level % 2 == 0) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        helper(node.left, level + 1, res);
        helper(node.right, level + 1, res);
    }
    // T/S: O(N)

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
