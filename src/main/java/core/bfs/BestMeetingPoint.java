package core.bfs;

import java.util.*;

/**
 * LC 296. Best Meeting Point
 * similar to LC 317. Shortest Distance from All Buildings
 */
public class BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        return getMin(rows) + getMin(cols);
    }

    private static int getMin(List<Integer> list) {
        int res = 0;
        Collections.sort(list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            res += list.get(j) - list.get(i);
            i++;
            j--;
        }
        return res;
    }
    // T: O(N * M)
    // S: O(N + M)

    // BFS, TLE
    public static int minTotalDistance2(int[][] grid) {
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
                    reach[i][j]++;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] curr = q.poll();
                            for (int[] d : dirs) {
                                int x = curr[0] + d[0], y = curr[1] + d[1];
                                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
                                    continue;
                                }
                                visited[x][y] = true;
                                distance[x][y] += level;
                                reach[x][y]++;
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
                if (reach[i][j] == buildingCounter) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    // T: O(N * M * N * M)
    // S: O(N * M)

    public static void main(String[] args) {
        System.out.println(minTotalDistance(new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
        System.out.println(minTotalDistance(new int[][]{{1,1}}));
    }

}
