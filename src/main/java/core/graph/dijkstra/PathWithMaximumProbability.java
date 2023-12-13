package core.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC 1514. Path with Maximum Probability
 */
public class PathWithMaximumProbability {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new HashMap<>());
            map.putIfAbsent(edges[i][1], new HashMap<>());
            map.get(edges[i][0]).put(edges[i][1], succProb[i]);
            map.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Node(1, start_node));
        double[] probs = new double[n];
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.node_id == end_node) {
                return curr.prob;
            }
            if (curr.prob <= probs[curr.node_id]) {
                continue;
            }
            probs[curr.node_id] = curr.prob;
            if (map.containsKey(curr.node_id)) {
                for (Map.Entry<Integer, Double> e : map.get(curr.node_id).entrySet()) {
                    pq.add(new Node(curr.prob * e.getValue(), e.getKey()));
                }
            }
        }
        return probs[end_node];
    }
    // N is the number of nodes, and M is the number of edges
    // T: O(M + N * logN)
    // S: O(N + M)

    static class Node{
        double prob;
        int node_id;

        public Node(double prob, int node_id) {
            this.prob = prob;
            this.node_id = node_id;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}},
                new double[]{0.5,0.5,0.2}, 0, 2));
        System.out.println(maxProbability(5, new int[][]{{1,4}, {2,4}, {0,4}, {0,3}, {0,2}, {2,3}},
                new double[]{0.37,0.17,0.93,0.23,0.39,0.04}, 3, 4));
    }
}
