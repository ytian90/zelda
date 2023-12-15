package core.bfs;

import core.utils.Pair;

import java.util.*;

/**
 * LC 314. Binary Tree Vertical Order Traversal
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // <column_offset, result>
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Pair of node and its column offset
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> curr = q.poll();
            TreeNode currNode = curr.getKey();
            Integer currColumn = curr.getValue();
            map.putIfAbsent(currColumn, new ArrayList<>());
            map.get(currColumn).add(currNode.val);
            min = Math.min(min, currColumn);
            max = Math.max(max, currColumn);
            if (currNode.left != null) {
                q.add(new Pair(currNode.left, currColumn - 1));
            }
            if (currNode.right != null) {
                q.add(new Pair(currNode.right, currColumn + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    // TS: O(N)

    public class TreeNode {
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
