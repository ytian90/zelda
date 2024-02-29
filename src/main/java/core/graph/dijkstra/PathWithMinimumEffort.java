package core.graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 1631. Path with Minimum Effort
 */
public class PathWithMinimumEffort {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] shortest = new int[n][m];
        for (int[] e : shortest) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1], d = curr[2];
            if (i == n - 1 && j == m - 1) {
                return d;
            }
            if (d > shortest[i][j]) {
                continue;
            }
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                int nd = Math.max(d, Math.abs(heights[x][y] - heights[i][j]));
                if (nd < shortest[x][y]) {
                    shortest[x][y] = nd;
                    pq.add(new int[]{x, y, nd});
                }
            }
        }
        return 0;
    }
    // T: O(N * M * log(NM))
    // S: O(N * M)
}
