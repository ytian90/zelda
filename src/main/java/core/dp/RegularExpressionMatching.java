package core.dp;

/**
 * LC 10. Regular Expression Matching
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return helper(0, 0, s, p, memo);
    }

    private boolean helper(int i, int j, String s, String p, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean res;
        if (j == p.length()) {
            res = i == s.length();
        } else {
            boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                res = helper(i, j + 2, s, p, memo) || match && helper(i + 1, j, s, p, memo);
            } else {
                res = match && helper(i + 1, j + 1, s, p, memo);
            }
        }
        return memo[i][j] = res;
    }
    // TS: O(N * M)

    public boolean isMatch2(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 2; j <= m; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char currS = s.charAt(i - 1), currP = p.charAt(j - 1);
                if (currS == currP || currP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currP == '*') {
                    char prevP = p.charAt(j - 2);
                    if (currS == prevP || prevP == '.') {
                        // multiple / single / empty(delete)
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n][m];
    }
    // TS: O(N * M)
}
