package core.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LC 1197. Minimum Knight Moves
 */
public class MinimumKnightMoves {
    int[][] dirs ={{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    public int minKnightMoves(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int level = 0;
        Set<int[]> visited = new HashSet<>();
        visited.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == x && curr[1] == y) {
                    return level;
                }
                for (int[] d : dirs) {
                    int nx = curr[0] + d[0], ny = curr[1] + d[1];
                    if (visited.contains(new int[]{nx, ny}) || nx < -1 || ny < -1) {
                        continue;
                    }
                    q.add(new int[]{nx, ny});
                    visited.add(new int[]{nx, ny});
                }
            }
            level++;
        }
        return -1;
    }
    // TS: O(N)
}
