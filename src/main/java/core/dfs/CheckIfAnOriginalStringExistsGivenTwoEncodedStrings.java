package core.dfs;

/**
 * LC 2060. Check if an Original String Exists Given Two Encoded Strings
 */
public class CheckIfAnOriginalStringExistsGivenTwoEncodedStrings {
    public boolean possiblyEquals(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        Boolean[][][] memo = new Boolean[n + 1][m + 1][2000];
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, memo);
    }

    private boolean dfs(char[] a, char[] b, int i, int j, int diff, Boolean[][][] memo) {
        if (i == a.length && j == b.length) {
            return diff == 0;
        }
        if (memo[i][j][diff + 1000] != null) {
            return memo[i][j][diff + 1000];
        }
        if (i < a.length && j < b.length && diff == 0 && a[i] == b[j]) {
            if (dfs(a, b, i + 1, j + 1, 0, memo)) {
                return memo[i][j][1000] = true;
            }
        }
        if (i < a.length && !Character.isDigit(a[i]) && diff > 0 && dfs(a, b, i + 1, j, diff - 1, memo)) {
            return memo[i][j][diff + 1000] = true;
        }
        if (j < b.length && !Character.isDigit(b[j]) && diff < 0 && dfs(a, b, i, j + 1, diff + 1, memo)) {
            return memo[i][j][diff + 1000] = true;
        }
        for (int k = i, val = 0; k < a.length && Character.isDigit(a[k]); k++) {
            val = 10 * val + (a[k] - '0');
            if (dfs(a, b, k + 1, j, diff - val, memo)) {
                return memo[i][j][diff + 1000] = true;
            }
        }
        for (int k = j, val = 0; k < b.length && Character.isDigit(b[k]); k++) {
            val = 10 * val + (b[k] - '0');
            if (dfs(a, b, i, k + 1, diff + val, memo)) {
                return memo[i][j][diff + 1000] = true;
            }
        }
        return memo[i][j][diff + 1000] = false;
    }
    // TS: O(N * M * D), where N is size of s1, M is size of s2, D = max(maximum numeric substring in s1, maximum numeric substring in s2)

}
