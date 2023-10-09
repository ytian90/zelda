package core.slidingwindow;

/**
 * 837. New 21 Game
 */
public class New21Game {
    public static double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1;
        }
        double[] dp = new double[n + 1];
        double pointSum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = pointSum / maxPts;
            if (i < k) {
                pointSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - maxPts >= 0) {
                pointSum -= dp[i - maxPts];
            }
        }
        return res;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(new21Game(21, 17, 10));
    }
}
