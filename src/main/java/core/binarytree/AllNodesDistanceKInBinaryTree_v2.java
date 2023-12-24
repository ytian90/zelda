package core.binarytree;

import java.util.*;

/**
 * LC 863. All Nodes Distance K in Binary Tree
 * DFS on Equivalent Graph solution
 */
public class AllNodesDistanceKInBinaryTree_v2 {
    Map<Integer, List<Integer>> graph;
    List<Integer> res;
    Set<Integer> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.graph = new HashMap<>();
        this.res = new ArrayList<>();
        this.visited = new HashSet<>();
        buildGraph(root, null);
        visited.add(target.val);
        dfs(target.val, 0, k);
        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node != null && parent != null) {
            graph.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(node.val);
        }
        if (node.left != null) {
            buildGraph(node.left, node);
        }
        if (node.right != null) {
            buildGraph(node.right, node);
        }
    }

    private void dfs(int curr, int distance, int k) {
        if (distance == k) {
            res.add(curr);
            return;
        }
        for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(next, 1 + distance, k);
            }
        }
    }
    // TS: O(N)

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree_v2 o = new AllNodesDistanceKInBinaryTree_v2();
        TreeNode n0 = new TreeNode(1);
        System.out.println(o.distanceK(n0, n0, 3));
    }
}
