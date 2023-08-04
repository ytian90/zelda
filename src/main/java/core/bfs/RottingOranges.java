package core.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 994. Rotting Oranges
 */
public class RottingOranges {
    private final static int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }
        if (oneCount == 0) {
            return 0;
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : DIRS) {
                    int x = curr[0] + d[0], y = curr[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                        continue;
                    }
                    q.add(new int[]{x, y});
                    oneCount--;
                    grid[x][y] = 2;
                }
            }
            level++;
        }
        return oneCount == 0 ? level - 1 : -1;
    }
    // TS: O(N * M)
}
