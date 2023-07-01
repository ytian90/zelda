package core.math;

/**
 * LC 1523. Count Odd Numbers in an Interval Range
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        if ((low & 1) == 0) {
            low++;
        }
        return low > high ? 0 : (high - low) / 2 + 1;
    }
    // TS: O(1)
}
