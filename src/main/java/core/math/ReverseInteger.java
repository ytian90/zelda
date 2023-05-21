package core.math;

/**
 * LC 7. Reverse Integer
 */
public class ReverseInteger {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = 10 * rev + x % 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) rev;
    }
    // Time: O(logX), there are roughly logX digits in x
    // Space: O(1)
}
