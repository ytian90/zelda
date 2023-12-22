package core.dp;

/**
 * LC 1216. Valid Palindrome III
 */
public class ValidPalindrome3 {
    // top-bottom + memo
    public static boolean isValidPalindrome(String s, int k) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, memo) <= k;
    }

    private static int helper(String s, int i, int j, Integer[][] memo) {
        if (j - i < 1) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = 0;
        if (s.charAt(i) == s.charAt(j)) {
            res = helper(s, i + 1, j - 1, memo);
        } else {
            res = 1 + Math.min(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j] = res;
    }
    // TS: O(N ^ 2)

    // bottom-up
    public boolean isValidPalindrome2(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] <= k;
    }
    // TS: O(N ^ 2)

    // bottom-up 1d
    public boolean isValidPalindrome3(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        int temp, prev;
        for (int i = s.length() - 2; i >= 0; i--) {
            prev = 0; // store the value of dp[i + 1][j - 1]
            for (int j = i + 1; j < n; j++) {
                temp = dp[j]; // store the value of dp[i + 1][j]
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n - 1] <= k;
    }
    // T: O(N ^ 2)
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("aaabaabaa", 1));
    }

}
