package core.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 695. Max Area of Island
 */
public class MaxAreaOfIsland_v2 {
    // bfs
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = -1;
        int res = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int x = curr[0] + d[0], y = curr[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                    continue;
                }
                grid[x][y] = -1;
                res++;
                q.add(new int[]{x, y});
            }
        }
        return res;
    }
    // TS: O(N * M)
}
