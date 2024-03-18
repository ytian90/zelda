package core.greedy;

import java.util.Arrays;

/**
 * LC 452. Minimum Number of Arrows to Burst Balloons
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (Integer.compare(a[0], b[0])));
        int end = points[0][1];
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                res++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return res + 1;
    }
    // T: O(N * logN)
    // S: O(N)
}
