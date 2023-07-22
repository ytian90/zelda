package core.dp;

/**
 * LC 152. Maximum Product Subarray
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSoFar = nums[0], minSoFar = nums[0];
        int res = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(Math.max(curr, maxSoFar * curr), minSoFar * curr);
            minSoFar = Math.min(Math.min(curr, maxSoFar * curr), minSoFar * curr);
            maxSoFar = tempMax;
            res = Math.max(res, maxSoFar);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
