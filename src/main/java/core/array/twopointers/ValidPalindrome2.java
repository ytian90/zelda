package core.array.twopointers;

/**
 * LC 680. Valid Palindrome II
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return valid(s, i + 1, j) || valid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean valid(String s, int start, int end) {
        if (start >= s.length() || end < 0) {
            return false;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // T: O(N)
    // S: O(1)
}
