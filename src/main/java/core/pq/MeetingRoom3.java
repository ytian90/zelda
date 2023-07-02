package core.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 2402. Meeting Rooms III
 */
public class MeetingRoom3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        int[] count = new int[n];
        // [room_id, end_time]
        PriorityQueue<int[]> engaged = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> unused = new PriorityQueue<>(); // room_id
        for (int i = 0; i < n; i++) {
            unused.add(i);
        }
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            // add all fit engaged back to unused
            while (!engaged.isEmpty() && engaged.peek()[1] <= start) {
                unused.add(engaged.poll()[0]);
            }
            // find first possible room from engaged and use it
            if (unused.isEmpty()) {
                int[] early = engaged.poll();
                int room = early[0], endTime = early[1];
                count[room]++;
                engaged.add(new int[]{room, endTime + (end - start)});
            } else { // find the smallest unused room and use it
                int room = unused.poll();
                count[room]++;
                engaged.add(new int[]{room, end});
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[res]) {
                res = i;
            }
        }
        return res;
    }
    // T: O(NlogN)
    // S: O(N)

}
