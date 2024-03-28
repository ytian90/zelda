package core.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 1438. Longest Continuous Subarray with Absolute Diff Less Than or Equal to Limit
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxq = new ArrayDeque<>();
        Deque<Integer> minq = new ArrayDeque<>();
        int i = 0, res = 0;
        for (int j = 0; j < nums.length; j++) {
            while (!maxq.isEmpty() && maxq.peekLast() < nums[j]) {
                maxq.pollLast();
            }
            while (!minq.isEmpty() && minq.peekLast() > nums[j]) {
                minq.pollLast();
            }
            maxq.offer(nums[j]);
            minq.offer(nums[j]);
            if (maxq.peekFirst() - minq.peekFirst() > limit) {
                if (nums[i] == maxq.peekFirst()) {
                    maxq.pollFirst();
                }
                if (nums[i] == minq.peekFirst()) {
                    minq.pollFirst();
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{2,2,2,4,4,2,5,5,5,5,5,2}, 2));
    }
}
