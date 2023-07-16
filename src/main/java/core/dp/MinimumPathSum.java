package core.dp;

/**
 * LC 64. Minimum Path Sum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int j = 1; j < m; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
    // T: O(N * M)
    // S: O(1)

    public static int minPathSum2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[0] += grid[i][0];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum2(new int[][]{
                {1,3,1}, {1,5,1}, {4,2,1}
        }));
    }
}
