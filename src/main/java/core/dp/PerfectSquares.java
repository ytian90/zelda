package core.dp;

/**
 * LC 279. Perfect Squares
 */
public class PerfectSquares {
    // bottom-up DP
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    // TS: O(N)
}
