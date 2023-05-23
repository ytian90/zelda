package core.sorting;

import java.util.Arrays;

/**
 * LC 252. Meeting Rooms
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
    // T: O(N * logN)
    // S: O(1)
}
