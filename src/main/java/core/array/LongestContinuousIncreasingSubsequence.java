package core.array;

/**
 * LC 674. Longest Continuous Increasing Subsequence
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                start = i;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
