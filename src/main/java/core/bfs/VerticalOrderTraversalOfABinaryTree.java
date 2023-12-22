package core.bfs;

import core.binarytree.TreeNode;
import core.utils.Pair;

import java.util.*;

/**
 * LC 987. Vertical Order Traversal of a Binary Tree
 * similar to LC 314. Binary Tree Vertical Order Traversal
 */
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
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
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curr = q.poll();
                TreeNode currNode = curr.getKey();
                Integer currColumn = curr.getValue();
                levelMap.putIfAbsent(currColumn, new ArrayList<>());
                levelMap.get(currColumn).add(currNode.val);
                min = Math.min(min, currColumn);
                max = Math.max(max, currColumn);
                if (currNode.left != null) {
                    q.add(new Pair(currNode.left, currColumn - 1));
                }
                if (currNode.right != null) {
                    q.add(new Pair(currNode.right, currColumn + 1));
                }
            }
            for (int key : levelMap.keySet()) {
                map.putIfAbsent(key, new ArrayList<>());
                Collections.sort(levelMap.get(key));
                map.get(key).addAll(levelMap.get(key));
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    // T: O(N * MlogM), where N is the total number of nodes, M is the worst number of conflicting nodes needs to sort
    // S: O(N)
}
