package core.dfs;

/**
 * LC 695. Max Area of Island
 */
public class MaxAreaOfIsland {
    // dfs
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int res = 1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                continue;
            }
            res += dfs(grid, x, y);
        }
        return res;
    }
    // TS: O(N * M)

}
