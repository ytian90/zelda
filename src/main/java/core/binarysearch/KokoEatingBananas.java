package core.binarysearch;

/**
 * LC 875. Koko Eating Bananas
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles) {
            max = Math.max(i, max);
        }
        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int hour = calculateHour(piles, mid);
            if (hour <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int calculateHour(int[] piles, int k) {
        int res = 0;
        for (int i : piles) {
            if (i % k == 0) {
                res += i / k;
            } else {
                res += i / k + 1;
            }
        }
        return res;
    }
    // T: O(N * logM), where N is the length of input array piles, M be the max number of bananas in single pile from piles
    // S: O(1)
}
