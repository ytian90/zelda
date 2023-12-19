package core.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 113. Path Sum II
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == targetSum) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(node.left, targetSum - node.val, list, res);
        helper(node.right, targetSum - node.val, list, res);
        list.remove(list.size() - 1);
    }
    // TS: O(N)
}
