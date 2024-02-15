package core.slidingwindow;

/**
 * LC 727. Minimum Window Subsequence
 */
public class MinimumWindowSubsequence {
    public static String minWindow(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (right < s1.length()) {
            int tIndex = 0;
            while (right < s1.length()) {
                if (s1.charAt(right) == s2.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == s2.length()) {
                    break;
                }
                right++;
            }
            if (right == s1.length()) {
                break;
            }
            int left = right;
            tIndex = s2.length() - 1;
            while (left >= 0) {
                if (s1.charAt(left) == s2.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex < 0) {
                    break;
                }
                left--;
            }
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                res = s1.substring(left, right + 1);
            }
            right = left + 1;
        }
        return res;
    }
    // T: O(S1 ^ 2)
    // S: O(1)

    // DP
    public String minWindow2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i + 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int start = 0, len = n + 1;
        for (int i = 1; i <= n; i++) {
            if (dp[i][m] > 0 && i - dp[i][m] + 1 < len) {
                start = dp[i][m] - 1;
                len = i - dp[i][m] + 1;
            }
        }
        return len == n + 1 ? "" : s1.substring(start, start + len);
    }
    // TS: O(N * M)

    public static void main(String[] args) {
        System.out.println(minWindow("abcdebdde", "bde"));
    }
}
