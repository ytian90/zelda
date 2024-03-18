package core.pq;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC 1439. Find the Kth Smallest Sum of a Matrix With Sorted Rows
 */
public class FindTheKthSmallestSumOfAMatrixWithSortedRows {
    public int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> next = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int j = 0; j < col; j++) {
                    next.add(i + row[j]);
                    if (next.size() > k) {
                        next.poll();
                    }
                }
            }
            pq = next;
        }
        return pq.poll();
    }
    // T: O(N * M * K * logK)
    // S: O(K)
}
