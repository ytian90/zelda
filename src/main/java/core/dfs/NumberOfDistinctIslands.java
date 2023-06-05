package core.dfs;

import java.util.*;

/**
 * LC 694. Number of Distinct Islands
 */
public class NumberOfDistinctIslands {
    // Hash by Path Signature
    public static int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<String> islands = new HashSet<>();
        boolean[][] visited = new boolean[n][m];
        StringBuilder curr;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                curr = new StringBuilder();
                if (visited[i][j] || grid[i][j] != 1) {
                    continue;
                }
                dfs(grid, i, j, visited, curr, '/');
                islands.add(curr.toString());
            }
        }
        return islands.size();
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, StringBuilder curr, char dir) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) {
            return;
        }
        visited[i][j] = true;
        curr.append(dir);
        dfs(grid, i + 1, j, visited, curr, 'D');
        dfs(grid, i - 1, j, visited, curr, 'U');
        dfs(grid, i, j + 1, visited, curr, 'R');
        dfs(grid, i, j - 1, visited, curr, 'L');
        curr.append('/'); // Z vs T
    }
    // TS: O(N * M)

    public static void main(String[] args) {
        System.out.println(numDistinctIslands(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        })); // 1
        // line 38 is to distinguish Z shape to T shape, use case is below.
        System.out.println(numDistinctIslands(new int[][]{
                {1,1,0},
                {0,1,1},
                {0,0,0},
                {1,1,1},
                {0,1,0}
        })); // 2
    }

    // Hash by Local Coordinates
    public static int numDistinctIslands2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<List<Integer>> island = new ArrayList<>();
                if (dfs(i, j, i, j, grid, island)) {
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean dfs(int i0, int j0, int i, int j, int[][] grid, List<List<Integer>> island) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] <= 0)
            return false;
        island.add(Arrays.asList(i - i0, j - j0));
        grid[i][j] *= -1;
        for (int[] d : dirs) {
            dfs(i0, j0, i + d[0], j + d[1], grid, island);
        }
        return true;
    }
    // TS: O(N * M)
}
