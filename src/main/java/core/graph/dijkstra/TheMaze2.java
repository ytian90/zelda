package core.graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 505. The Maze II
 */
public class TheMaze2 {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        int[][] shortest = new int[n][m];
        for (int[] e : shortest) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.add(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1], d = curr[2];
            if (d >= shortest[i][j]) {
                continue;
            }
            shortest[i][j] = d;
            for (int[] dir : dirs) {
                int x = i, y = j, nd = d;
                while (valid(x + dir[0], y + dir[1], maze)) {
                    x += dir[0];
                    y += dir[1];
                    nd++;
                }
                pq.add(new int[]{x, y, nd});
            }
        }
        return shortest[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 : shortest[destination[0]][destination[1]];
    }
    // T: O(N * M * log(NM))
    // S: O(N * M)

    private boolean valid(int i, int j, int[][] maze) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length) {
            return false;
        }
        return maze[i][j] == 0;
    }
}
