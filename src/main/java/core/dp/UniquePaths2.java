package core.dp;

/**
 * LC 63. Unique Path II
 */
public class UniquePaths2 {
    // 2D
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] += dp[i - 1][0];
            } else break;
        }
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] += dp[0][j - 1];
            } else break;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    // TS: O(N * M)

    // 1D
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
    // T: O(N * M)
    // S: O(M)
}
