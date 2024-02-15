package core.binarysearch;

/**
 * LC 1891. Cutting Ribbons
 */
public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        int max = 0;
        for (int i : ribbons) {
            max = Math.max(i, max);
        }
        int lo = 1, hi = max + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = calculate(ribbons, mid);
            if (count < k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    private int calculate(int[] nums, int target) {
        int res = 0;
        for (int i : nums) {
            res += i / target;
        }
        return res;
    }
    // T: O(N * log(max length))
    // S: O(1)
}
