package core.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 1245. Tree Diameter
 */
public class TreeDiameter_v2 {
    // bfs
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
        int[] distance = bfs(0, graph);
        int[] res = bfs(distance[0], graph);
        return res[1];
    }

    // [node_id, distance]
    private int[] bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[graph.size()];
        visited[start] = true;
        int lastNode = start, distance = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (Integer next : graph.get(curr)) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    q.add(next);
                    lastNode = next;
                }
            }
            distance++;
        }
        return new int[]{lastNode, distance};
    }
    // TS: O(N)
}
