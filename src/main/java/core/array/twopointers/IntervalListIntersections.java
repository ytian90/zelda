package core.array.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 986. Interval List Intersections
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int n = firstList.length, m = secondList.length;
        List<int[]> list = new ArrayList<>();
        while (i < n && j < m) {
            int[] first = firstList[i], second = secondList[j];
            int lo = Math.max(first[0], second[0]);
            int hi = Math.min(first[1], second[1]);
            if (lo <= hi) {
                list.add(new int[]{lo, hi});
            }
            if (first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    // TS: O(N + M)
}
