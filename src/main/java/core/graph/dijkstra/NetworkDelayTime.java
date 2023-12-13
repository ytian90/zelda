package core.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e : times) {
            map.putIfAbsent(e[0], new HashMap<>());
            map.get(e[0]).put(e[1], e[2]);
        }
        // [distance, node_id]
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        pq.add(new int[]{0, k});
        boolean[] visited = new boolean[n + 1];
        int res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDistance = curr[0], currNode = curr[1];
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            res = currDistance;
            n--;
            if (map.containsKey(currNode)) {
                for (Map.Entry<Integer, Integer> entry : map.get(currNode).entrySet()) {
                    pq.add(new int[]{currDistance + entry.getValue(), entry.getKey()});
                }
            }
        }
        return n == 0 ? res : -1;
    }
    // T/S: O(V + E)
}
