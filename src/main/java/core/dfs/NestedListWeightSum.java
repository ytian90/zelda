package core.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 339. Nested List Weight Sum
 */
public class NestedListWeightSum {
    // DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> list, int weight) {
        int res = 0;
        for (NestedInteger i : list) {
            if (i.isInteger()) {
                res += i.getInteger() * weight;
            } else {
                res += depthSum(i.getList(), weight + 1);
            }
        }
        return res;
    }
    // T: O(N), where N is the total number of integers in nested list
    // S: O(N)

    // BFS
    public int depthSum2(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        int depth = 1;
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    res += curr.getInteger() * depth;
                } else {
                    q.addAll(curr.getList());
                }
            }
            depth++;
        }
        return res;
    }
    // T: O(N), where N is the total number of integers in nested list
    // S: O(N)

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
