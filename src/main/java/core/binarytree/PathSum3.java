package core.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 437. Path Sum III
 */
public class PathSum3 {
    int res = 0;
    int targetSum;
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, long currSum) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        if (currSum == targetSum) {
            res++;
        }
        res += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        helper(node.left, currSum);
        helper(node.right, currSum);
        // remove the current sum from map to avoid using it during parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);
    }
    // TS: O(N)

    public static void main(String[] args) {
        PathSum3 obj = new PathSum3();
        // use case for the last line of code in helper
        TreeNode n0 = new TreeNode(1);
        n0.left = new TreeNode(-2);
        n0.right = new TreeNode(-3);
        System.out.println(obj.pathSum(n0, -1));
    }
}
