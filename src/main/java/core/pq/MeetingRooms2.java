package core.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 253. Meeting Rooms II
 */
public class MeetingRooms2 {
    // Priority Queue
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (!pq.isEmpty() && pq.peek()[1] <= intervals[i][0]) {
                int[] curr = pq.poll();
                curr[1] = Math.max(curr[1], intervals[i][1]);
                pq.add(curr);
            } else {
                pq.add(intervals[i]);
            }
        }
        return pq.size();
    }
    // T: O(N * logN)
    // S: O(N)

    // Chronological Ordering
    public int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] s = new int[n], e = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            s[i] = intervals[i][0];
            e[i] = intervals[i][1];
        }
        Arrays.sort(s);
        Arrays.sort(e);
        int res = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] < e[index]) {
                res++;
            } else {
                index++;
            }
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(N)
}
