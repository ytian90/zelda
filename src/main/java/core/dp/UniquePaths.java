package core.dp;

import java.util.Arrays;

/**
 * LC 62. Unique Paths
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
    // T: O(M * N)
    // S: O(N)
}
