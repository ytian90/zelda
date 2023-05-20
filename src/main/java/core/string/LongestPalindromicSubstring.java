package core.string;

/**
 * LC 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // [start, end)
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i, res);
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                helper(s, i, i + 1, res);
            }
        }
        return s.substring(res[0], res[1]);
    }

    private void helper(String s, int i, int j, int[] res) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (res[1] - res[0] < j - (i + 1)) {
            res[1] = j;
            res[0] = i + 1;
        }
    }
    // Time: O(N ^ 2)
    // Space: O(1)
}
