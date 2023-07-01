package core.math;

/**
 * LC 9. Palindrome Number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // x is negative or ending with 0, return false
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int res = 0;
        while (x > res) {
            res = 10 * res + x % 10;
            x /= 10;
        }
        return res == x || res / 10 == x;
    }
    // TS: O(1)
}
