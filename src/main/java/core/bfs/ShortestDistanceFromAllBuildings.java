package core.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 317. Shortest Distance from All Buildings
 * similar to LC 296. Best Meeting Point
 */
public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int n = grid.length, m = grid[0].length;
        int[][] distance = new int[n][m];
        int[][] reach = new int[n][m];
        int buildingCounter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    buildingCounter++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    int level = 1;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] curr = q.poll();
                            for (int[] d : dirs) {
                                int x = curr[0] + d[0], y = curr[1] + d[1];
                                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || grid[x][y] != 0) {
                                    continue;
                                }
                                distance[x][y] += level;
                                reach[x][y]++;
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingCounter) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    // T: O(N * M * N * M)
    // S: O(N * M)

    public int shortestDistance2(int[][] grid) {
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int n = grid.length, m = grid[0].length;
        int[][] total = new int[n][m];
        int emptyLandValue = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Integer.MAX_VALUE;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i ,j});
                    int steps = 1;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] curr = q.poll();
                            for (int[] d : dirs) {
                                int x = curr[0] + d[0], y = curr[1] + d[1];
                                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != emptyLandValue) {
                                    continue;
                                }
                                grid[x][y]--;
                                total[x][y] += steps;
                                q.offer(new int[]{x, y});
                                res = Math.min(res, total[x][y]);
                            }
                        }
                        steps++;
                    }
                    emptyLandValue--;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    // T: O(N * M * N * M)
    // S: O(N * M)

}
