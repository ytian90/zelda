package core.binarysearch;

/**
 * LC 367. Valid Perfect Square
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
    // T: O(logN)
    // S: O(1)
}
