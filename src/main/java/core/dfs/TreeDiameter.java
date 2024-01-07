package core.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1245. Tree Diameter
 */
public class TreeDiameter {
    // dfs
    private Integer diameter = 0;

    public int treeDiameter(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs(0, -1, graph);
        return diameter;
    }

    private int dfs(int curr, int parent, List<List<Integer>> graph) {
        int distance1 = 0, distance2 = 0;
        for (Integer next : graph.get(curr)) {
            if (next == parent) continue;
            int distance = 1 + dfs(next, curr, graph);
            if (distance > distance1) {
                distance2 = distance1;
                distance1 = distance;
            } else if (distance > distance2) {
                distance2 = distance;
            }
        }
        diameter = Math.max(diameter, distance1 + distance2);
        return distance1;
    }
    // TS: O(N)

}
