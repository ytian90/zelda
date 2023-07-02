package core.graph;

import java.util.*;

/**
 * LC 787. Cheapest Flights within K Stops
 */
public class CheapestFlightsWithinKStops {
    // BFS Queue
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] f : flights) {
            adj.computeIfAbsent(f[0], value -> new ArrayList<>())
                .add(new int[]{f[1], f[2]});
        }
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>(); // [stop_id, price]
        q.offer(new int[]{src, 0});
        int stops = 0;
        while (stops <= k && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr =  q.poll();
                int stop = curr[0], price = curr[1];
                if (!adj.containsKey(stop)) {
                    continue;
                }
                for (int[] e : adj.get(stop)) {
                    int nextStop = e[0], nextPrice = e[1];
                    if (price + nextPrice < prices[nextStop]) {
                        prices[nextStop] = price + nextPrice;
                        q.add(new int[]{nextStop, prices[nextStop]});
                    }
                }
            }
            stops++;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
    // TS: O(N)

    // Bellman Ford: find the shortest paths from the source node to all other vertices ina weighted graph
    // The shortest path contains at most N - 1 edges because the path can't have a cycle
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] t = Arrays.copyOf(prices, n);
            for (int[] f : flights) {
                if (prices[f[0]] != Integer.MAX_VALUE) {
                    t[f[1]] = Math.min(t[f[1]], prices[f[0]] + f[2]);
                }
            }
            prices = t;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
    // T: O((V + E) * K)
    // S: O(V)

    // Dijkstra: Priority Queue
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] f : flights) {
            adj.computeIfAbsent(f[0], value -> new ArrayList<>())
                    .add(new int[]{f[1], f[2]});
        }
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        // [prices from source to curr stop, current stop, total stop count]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int price = t[0], node = t[1], steps = t[2];
            if (steps > stops[node] || steps > k + 1) {
                continue;
            }
            stops[node] = steps;
            if (node == dst) {
                return price;
            }
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int[] a : adj.get(node)) {
                pq.add(new int[]{price + a[1], a[0], steps + 1});
            }
        }
        return -1;
    }
    // T: O(V + E * K * log(EK))
    // S: O(V + E * K)

}
