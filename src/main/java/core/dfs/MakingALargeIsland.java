package core.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 827. Making a Large Island
 */
public class MakingALargeIsland {
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int tag = 2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        boolean[][] visited = new boolean[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int r = dfs(grid, i, j, tag, visited);
                    map.put(tag++, r);
                    res = Math.max(res, r);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int curr = 1;
                    Set<Integer> neighborTags = new HashSet<>();
                    if (i - 1 >= 0) neighborTags.add(grid[i - 1][j]);
                    if (i + 1 < n) neighborTags.add(grid[i + 1][j]);
                    if (j - 1 >= 0) neighborTags.add(grid[i][j - 1]);
                    if (j + 1 < n) neighborTags.add(grid[i][j + 1]);
                    for (int t : neighborTags) {
                        curr += map.get(t);
                    }
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j, int tag, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }
        visited[i][j] = true;
        grid[i][j] = tag;
        return 1 + dfs(grid, i - 1, j, tag, visited) + dfs(grid, i + 1, j, tag, visited) + dfs(grid, i, j - 1, tag, visited) + dfs(grid, i, j + 1, tag, visited);
    }
    // TS: O(N ^ 2)

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }

}
