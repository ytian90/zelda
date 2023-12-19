package core.binarysearch;

/**
 * LC 528. Random Pick with Weight
 */
public class RandomPickWithWeight {
    private int[] prefixSums;
    private int totalSum;

    public RandomPickWithWeight(int[] w) {
        this.prefixSums = new int[w.length];
        int prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }
    // TS: O(N)

    // linear solution
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        for (int i = 0; i < prefixSums.length; i++) {
            if (target < prefixSums[i]) {
                return i;
            }
        }
        return -1;
    }
    // T: O(N)
    // S: O(1)

    // binary search
    public int pickIndex2() {
        double target = this.totalSum * Math.random();
        int lo = 0, hi = this.prefixSums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefixSums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    // T: O(logN)
    // S: O(1)

}
