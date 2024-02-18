package core.topologicalsort;

import java.util.*;

/**
 * LC 310. Minimum Height Trees
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.putIfAbsent(e[0], new HashSet<>());
            adj.putIfAbsent(e[1], new HashSet<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> e : adj.entrySet()) {
            if (e.getValue().size() == 1) {
                leaves.add(e.getKey());
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                for (int j : adj.get(i)) {
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) {
                        newLeaves.add(j);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
    // TS: O(N), where N is the total number of nodes in graph.
}
