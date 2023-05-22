package core.dfs;

/**
 * LC 200. Number of Islands
 */
public class NumberOfIslands {
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        for (int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
    // T/S: O(N * M)
}
