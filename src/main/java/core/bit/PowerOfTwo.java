package core.bit;

/**
 * LC 231. Power of Two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res == 1;
    }
    // TS: O(1)

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
    // TS: O(1)
}
