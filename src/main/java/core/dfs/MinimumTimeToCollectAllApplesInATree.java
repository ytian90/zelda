package core.dfs;

import java.util.*;

/**
 * LC 1443. Minimum Time to Collect All Apples in a Tree
 */
public class MinimumTimeToCollectAllApplesInATree {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        return dfs(0, -1, adj, hasApple);
    }

    private static int dfs(int curr, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        if (!adj.containsKey(curr)) {
            return 0;
        }
        int totalTime = 0, childTime = 0;
        for (int child : adj.get(curr)) {
            if (child == parent) {
                continue;
            }
            childTime = dfs(child, curr, adj, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(minTime(7, new int[][]{{0,1}, {0,2}, {1,4}, {1,5}, {2,3}, {2,6}}, Arrays.asList(false, false, true, false, true, true, false)));
    }

}
