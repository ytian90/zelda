package core.binarysearch;

/**
 * LC 278. First Bad Version
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    // T: O(logN)
    // S: O(1)

    boolean isBadVersion(int version) {
        return false;
    }
}
