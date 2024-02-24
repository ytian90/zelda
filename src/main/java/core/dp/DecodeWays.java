package core.dp;

/**
 * LC 91. Decode Ways
 */
public class DecodeWays {
    // recursion + memorization
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0, new Integer[s.length()]);
    }

    private int helper(String s, int pos, Integer[] memo) {
        int n = s.length();
        if (pos == n) {
            return 1;
        }
        if (s.charAt(pos) == '0') {
            return 0;
        }
        if (memo[pos] != null) {
            return memo[pos];
        }
        int res = helper(s, pos + 1, memo);
        if (pos < n - 1 && (s.charAt(pos) == '1' || s.charAt(pos) == '2' && s.charAt(pos + 1) < '7')) {
            res += helper(s, pos + 2, memo);
        }
        return memo[pos] = res;
    }
    // TS: O(N)

    // DP
    public int numDecodings2(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            dp[i] = dp[i + 1];
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
    // TS: O(N)
}
