package core.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 257. Binary Tree Paths
 */
public class BinaryTreePaths {
    // DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, List<String> path, List<String> res) {
        if (root == null) {
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", new ArrayList<>(path)));
        }
        dfs(root.left, path, res);
        dfs(root.right, path, res);
        path.remove(path.size() - 1);
    }
    // TS: O(N)

    // Iteration BFS
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, Integer.toString(root.val)));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            TreeNode node = curr.node;
            String path = curr.path;
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.left != null) {
                q.add(new Node(node.left, path + "->" + node.left.val));
            }
            if (node.right != null) {
                q.add(new Node(node.right, path + "->" + node.right.val));
            }
        }
        return res;
    }
    // TS: O(N)

    class Node{
        TreeNode node;
        String path;

        public Node(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

}
