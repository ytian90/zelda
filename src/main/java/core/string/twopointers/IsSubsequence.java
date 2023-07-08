package core.string.twopointers;

/**
 * LC 392. Is Subsequence
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
    // T: O(N), where N is the length sum of s and t
    // S: O(1)
}
