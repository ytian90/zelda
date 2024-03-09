package core.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 934. Shortest Bridge
 */
public class ShortestBridge {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    found = true;
                    break; // break j
                }
            }
            if (found) {
                break; // break i
            }
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0], y = curr[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return steps;
                    }
                    q.add(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        grid[i][j] = 2;
        q.add(new int[]{i, j});
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                continue;
            }
            dfs(grid, x, y, q);
        }
    }
    // TS: O(N ^ 2)

    public static void main(String[] args) {
        ShortestBridge o = new ShortestBridge();
        System.out.println(o.shortestBridge(new int[][]{{0,1}, {1,0}}));
        System.out.println(o.shortestBridge(new int[][]{
                {0,0,1,0,1},{0,1,1,0,1},{0,1,0,0,1},{0,0,0,0,0},{0,0,0,0,0}
        }));
    }
}
