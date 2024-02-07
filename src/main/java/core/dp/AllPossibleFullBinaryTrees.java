package core.dp;

import core.binarytree.TreeNode;

import java.util.*;

/**
 * LC 894. All Possible Full Binary Trees
 */
public class AllPossibleFullBinaryTrees {
    // top-bottom DP
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    res.add(new TreeNode(0, l, r));
                }
            }
        }
        return res;
    }
    // TS: O(2 ^ N)

}
