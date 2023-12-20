package core.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 973. K Closest Points to Origin
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.poll();
        }
        return res;
    }
    // T: O(N * logK)
    // S: O(K)

    public static void main(String[] args) {
        for (int[] a : kClosest(new int[][]{{3,3}, {5,-1}, {-2,4}}, 2)) {
            System.out.println(Arrays.toString(a));
        }
    }
}
