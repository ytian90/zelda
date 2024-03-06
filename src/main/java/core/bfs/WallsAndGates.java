package core.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 286. Walls and Gates
 */
public class WallsAndGates {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int n = rooms.length, m = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int x = curr[0] + d[0], y = curr[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || rooms[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[x][y] = 1 + rooms[curr[0]][curr[1]];
                q.add(new int[]{x, y});
            }
        }
    }
    // TS: O(N * M)
}
