package core.bfs;

import java.util.*;

/**
 * LC 815. Bus Routes
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // <stop, routes which pass this stop>
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new HashSet<>());
                map.get(stop).add(i);
            }
        }
        // [stop, bus_counter]
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{source, 0});
        Set<Integer> seenStop = new HashSet<>();
        seenStop.add(source);
        boolean[] seenRoutes = new boolean[n];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int stop = curr[0], busCount = curr[1];
            if (stop == target) {
                return busCount;
            }
            for (int i : map.get(stop)) {
                if (seenRoutes[i]) {
                    continue;
                }
                for (int j : routes[i]) {
                    if (seenStop.contains(j)) {
                        continue;
                    }
                    seenStop.add(j);
                    q.add(new int[]{j, 1 + busCount});
                }
                seenRoutes[i] = true;
            }
        }
        return -1;
    }

}
