package core.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 863. All Nodes Distance K in Binary Tree
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        find(root, target, map);
        dfs(root, k, map.get(root), res, map);
        return res;
    }

    private int find(TreeNode node, TreeNode target, Map<TreeNode, Integer> map) {
        if (node == null) {
            return -1;
        }
        if (node == target) {
            map.put(target, 0);
            return 0;
        }
        int left = find(node.left, target, map);
        int right = find(node.right, target, map);
        int res = Math.max(left, right);
        if (res >= 0) {
            map.put(node, 1 + res);
            return 1 + res;
        }
        return -1;
    }
    // TS: O(N)

    private void dfs(TreeNode node, int k, int length, List<Integer> res, Map<TreeNode, Integer> map) {
        if (node == null) {
            return;
        }
        if (map.containsKey(node)) {
            length = map.get(node);
        }
        if (length == k) {
            res.add(node.val);
        }
        dfs(node.left, k, 1 + length, res, map);
        dfs(node.right, k, 1 + length, res, map);
    }
    // TS: O(N)

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree o = new AllNodesDistanceKInBinaryTree();
        TreeNode n0 = new TreeNode(3);
        n0.left = new TreeNode(5);
        n0.right = new TreeNode(1);
        n0.left.left = new TreeNode(6);
        n0.left.right = new TreeNode(2);
        n0.left.right.left = new TreeNode(7);
        n0.left.right.right = new TreeNode(4);
        n0.right.left = new TreeNode(0);
        n0.right.right = new TreeNode(8);

        System.out.println(o.distanceK(n0, n0.left, 2));
    }

}
