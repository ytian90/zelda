package core.dp;

/**
 * LC 647. Palindromic Substring
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += helper(s, i, i);
            res += helper(s, i, i + 1);
        }
        return res;
    }

    private int helper(String s, int i, int j) {
        int c = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            c++;
        }
        return c;
    }
    // T: O(N ^ 2)
    // S: O(1)

}
