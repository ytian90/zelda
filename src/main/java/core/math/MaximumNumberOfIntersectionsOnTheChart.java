package core.math;

import java.util.Map;
import java.util.TreeMap;

/**
 * LC 3009. Maximum Number of Intersections on the Chart
 */
public class MaximumNumberOfIntersectionsOnTheChart {
    public int maxIntersectionCount(int[] y) {
        int n = y.length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            int start = 2 * y[i - 1];
            int end = 2 * y[i] + (i == n - 1 ? 0 : y[i] > y[i - 1] ? -1 : 1);
            map.put(Math.min(start, end), map.getOrDefault(Math.min(start, end), 0) + 1);
            map.put(Math.max(start, end) + 1, map.getOrDefault(Math.max(start, end) + 1, 0) - 1);
        }
        int count = 0, res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            count += e.getValue();
            res = Math.max(res, count);
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(N)
}
