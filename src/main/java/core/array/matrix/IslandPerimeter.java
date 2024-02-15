package core.array.matrix;

/**
 * LC 463. Island Perimeter
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int island = 0, neighbor = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        neighbor++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return 4 * island - 2 * neighbor;
    }
    // T: O(N * M)
    // S: O(1)
}
