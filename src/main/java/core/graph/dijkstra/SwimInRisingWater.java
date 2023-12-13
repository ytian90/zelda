package core.graph.dijkstra;

import java.util.PriorityQueue;

/**
 * LC 778. Swim in Rising Water
 */
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (grid[a[0]][a[1]] - grid[b[0]][b[1]]));
        pq.add(new int[]{0, 0});
        int level = 0;
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            level = Math.max(level, grid[curr[0]][curr[1]]);
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return level;
            }
            for (int[] d : dirs) {
                int x = curr[0] + d[0], y = curr[1] + d[1];
                if (x < 0 || x > n - 1 || y < 0 || y > n - 1 || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                pq.add(new int[]{x, y});
            }
        }
        return level;
    }
    // T: O(N ^ 2 * logN)
    // S: O(N ^ 2)
}
