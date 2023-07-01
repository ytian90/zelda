package youtube;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=V8DGdPkBBxg
 * https://alexgolec.dev/ratio-finder/
 * example facts:
 *   m = 3.28 ft
 *   ft = 12 in
 *   hr = 60 min
 *   min = 60 sec
 * example queries:
 *   2 m = ? in --> answer = 78.72
 *   13 in = ? m --> answer = 0.330 (roughly)
 *   13 in = ? hr --> null "not convertible!"
 */
public class RatioFinder {
    class RateGraph {
        public Map<String, Map<String, Double>> graphMap = new HashMap<>();

        public void addConversion(String start, String dest, double rate) {
            addConv(start, dest, rate);
            addConv(dest, start, 1 / rate);
        }

        private void addConv(String start, String dest, double rate) {
            if (!graphMap.containsKey(start)) {
                graphMap.put(start, new HashMap<>());
            }
            if (!graphMap.get(start).containsKey(dest)) {
                graphMap.get(start).put(dest, rate);
            }
        }
    }

    public Double resolveRatioRate(String start, String dest, double amount) {
        RateGraph rateGraph = new RateGraph();
        loadRatios(rateGraph);
        return dfs(rateGraph.graphMap, start, dest, amount, new HashSet<>());
    }

    private Double dfs(Map<String, Map<String, Double>> graphMap, String start, String dest,
                       double amount, HashSet<String> visited) {
        if (!graphMap.containsKey(start)) {
            return null;
        }
        if (start.equals(dest)) {
            return amount;
        }
        visited.add(start);
        for (String next : graphMap.get(start).keySet()) {
            if (visited.contains(next)) {
                continue;
            }
            Double res = dfs(graphMap, next, dest, amount * graphMap.get(start).get(next), visited);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RatioFinder rf = new RatioFinder();
        System.out.println(rf.resolveRatioRate("m", "in", 2));
        System.out.println(rf.resolveRatioRate("in", "m", 13));
        System.out.println(rf.resolveRatioRate("in", "hr", 13));
    }

    private void loadRatios(RateGraph rateGraph) {
        rateGraph.addConversion("m", "ft", 3.28);
        rateGraph.addConversion("ft", "in", 12);
        rateGraph.addConversion("hr", "min", 60);
        rateGraph.addConversion("min", "sec", 60);
    }
}

