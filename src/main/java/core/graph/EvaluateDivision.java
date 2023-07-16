package core.graph;

import java.util.*;

/**
 * LC 399. Evaluate Division
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            map.putIfAbsent(e.get(0), new HashMap<>());
            map.putIfAbsent(e.get(1), new HashMap<>());
            map.get(e.get(0)).put(e.get(1), values[i]);
            map.get(e.get(1)).put(e.get(0), 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, map, new HashSet<>());
        }
        return res;
    }

    private double dfs(String start, String end, double value, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!map.containsKey(start) || !map.containsKey(end) || visited.contains(start)) {
            return -1;
        }
        if (start.equals(end)) {
            return value;
        }
        visited.add(start);
        Map<String, Double> next = map.get(start);
        for (String s : next.keySet()) {
            double res = dfs(s, end, value * next.get(s), map, visited);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }
    // T: O(E + Q * (V + E)), V is number of nodes, E is number of edges, Construct the adjacent list O(E),
    // DFS of graph (V + E), Q is the number of queries
    // S: O(2 * E + Q)
}
