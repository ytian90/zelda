package core.array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 57. Insert Interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        for (int[] e : intervals) {
            if (e[1] < start) {
                list.add(e);
            } else if (end < e[0]) {
                list.add(new int[]{start, end});
                start = e[0];
                end = e[1];
            } else {
                start = Math.min(start, e[0]);
                end = Math.max(end, e[1]);
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    // TS: O(N)
}
