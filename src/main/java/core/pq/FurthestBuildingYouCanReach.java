package core.pq;

import java.util.PriorityQueue;

/**
 * LC 1642. Furthest Building You Can Reach
 */
public class FurthestBuildingYouCanReach {
    // small diff use bricks, large diff use ladders
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if (d > 0) {
                pq.add(d);
            }
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
    // T: O(N * logN)
    // S: O(N)
}
