package core.dp;

/**
 * LC 1143. Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    // Recursive + memo
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        Integer[][] memo = new Integer[n + 1][m + 1];
        return helper(text1, 0, text2, 0, memo);
    }

    private int helper(String text1, int p, String text2, int q, Integer[][] memo) {
        if (p == text1.length() || q == text2.length()) {
            return 0;
        }
        if (memo[p][q] != null) {
            return memo[p][q];
        }
        int res = 0;
        if (text1.charAt(p) == text2.charAt(q)) {
            res = 1 + helper(text1, p + 1, text2, q + 1, memo);
        } else {
            res = Math.max(helper(text1, p + 1, text2, q, memo), helper(text1, p, text2, q + 1, memo));
        }
        return memo[p][q] = res;
    }
    // TS: O(N * M)

    // DP 2D bottom-up
    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
    // TS: O(N * M)

    public int longestCommonSubsequence3(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[] dp = new int[m + 1], prev = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            dp = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = 1 + prev[j - 1];
                } else {
                    dp[j] = Math.max(prev[j], dp[j - 1]);
                }
            }
            prev = dp;
        }
        return dp[m];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence o = new LongestCommonSubsequence();
        System.out.println(o.longestCommonSubsequence("abc", "def")); // 0
        System.out.println(o.longestCommonSubsequence("abc", "a")); // 1
        System.out.println(o.longestCommonSubsequence3("abcba", "abcbcba")); // 5
        System.out.println(o.longestCommonSubsequence("ezupkr", "ubmrapg")); // 2
    }

}
