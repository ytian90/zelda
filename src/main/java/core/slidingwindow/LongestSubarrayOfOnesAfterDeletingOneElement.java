package core.slidingwindow;

/**
 * LC 1493. Longest Subarray of 1's After Deleting One Element
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 0, res = 0, zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
            while (zeroCount > 1) {
                zeroCount -= (nums[prev] == 0 ? 1 : 0);
                prev++;
            }
            res = Math.max(res, i - prev);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
