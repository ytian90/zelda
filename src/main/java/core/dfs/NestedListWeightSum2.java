package core.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 364. Nested List Weight Sum II
 */
public class NestedListWeightSum2 {
    // DFS + max depth calculation
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return depthSum(nestedList, maxDepth);
    }

    private int depthSum(List<NestedInteger> list, int weight) {
        int res = 0;
        for (NestedInteger i : list) {
            if (i.isInteger()) {
                res += i.getInteger() * weight;
            } else {
                res += depthSum(i.getList(), weight - 1);
            }
        }
        return res;
    }

    private int getMaxDepth(List<NestedInteger> list) {
        int res = 1;
        for (NestedInteger i : list) {
            if (!i.isInteger() && i.getList().size() > 0) {
                int depth = 1 + getMaxDepth(i.getList());
                res = Math.max(res, depth);
            }
        }
        return res;
    }
    // TS: O(N)

    // past: sum of all existing values after each level
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        int past = 0, res = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> next = new ArrayList<>();
            for (NestedInteger i : nestedList) {
                if (i.isInteger()) {
                    past += i.getInteger();
                } else {
                    next.addAll(i.getList());
                }
            }
            res += past;
            nestedList = next;
        }
        return res;
    }
    // TS: O(N)

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedListWeightSum.NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
