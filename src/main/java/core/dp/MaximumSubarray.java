package core.dp;

/**
 * LC 53. Maximum Subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            globalMax = Math.max(currMax, globalMax);
        }
        return globalMax;
    }
    // T: O(N)
    // S: O(1)
}
