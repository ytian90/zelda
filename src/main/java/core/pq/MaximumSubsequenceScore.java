package core.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 2542. Maximum Subsequence Score
 */
public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> (b[1] - a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += pairs[i][0];
            pq.add(pairs[i][0]);
        }
        long res = sum * pairs[k - 1][1];
        for (int i = k; i < n; i++) {
            sum += pairs[i][0] - pq.poll();
            pq.add(pairs[i][0]);
            res = Math.max(res, sum * pairs[i][1]);
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(N)
}
