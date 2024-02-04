package core.greedy;

import java.util.Arrays;

/**
 * LC 435. Non-overlapping Intervals
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int res = 0;
        int k = Integer.MIN_VALUE;
        for (int[] i : intervals) {
            int s = i[0], e = i[1];
            if (k <= s) {
                k = e;
            } else {
                res++;
            }
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(N)
}
