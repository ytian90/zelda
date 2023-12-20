package core.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1091. Shortest Path in Binary Matrix
 */
public class ShortestPathInBinaryMatrix {
    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            for (int[] d : dirs) {
                int x = curr[0] + d[0], y = curr[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || visited[x][y]) {
                    continue;
                }
                q.add(new int[]{x, y, curr[2] + 1});
                visited[x][y] = true;
            }
        }
        return -1;
    }
    // TS: O(N * M)

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0}, {1, 1, 0}, {1, 1, 1}
        }));
    }
}
